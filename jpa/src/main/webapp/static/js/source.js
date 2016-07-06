/**
 * Created by Answer on 16/6/29.
 */

function initSourcePage() {
    // 改变导航栏状态
    $('#nav-datasource').addClass('active');
    initDataSourceTable();
    initDetailTable();
    initSchemaTree($('#schemaTree'), $('#detialTable'));
    initValidator();
    $("#type").select2({
        minimumResultsForSearch: Infinity,
        data: Global.DBTypt
    });
}
function initDataSourceTable() {
    $('#dataSourceTable').bootstrapTable({
        url: '/source/get',
        height: '300',
        showRefresh: true,
        pagination: true,
        pageNumber: '1',
        sidePagination: 'server',
        toolbar: '#dataSourceTableToolbar',
        queryParamsType: 'size',
        singleSelect: true,
        clickToSelect: true,
        columns: [{
            field: 'checkbox',
            title: '',
            checkbox: true
        }, {
            field: 'alias',
            title: '名称',
            align: 'center'
        }, {
            field: 'type',
            title: '数据类型',
            align: 'center',
            formatter: 'cellTypeFormatter'
        }, {
            field: 'ip',
            title: 'IP',
            align: 'center'
        }, {
            field: 'port',
            title: '端口',
            align: 'center'
        }, {
            field: 'status',
            title: '加密状态',
            align: 'center',
            formatter: 'cellStatusFormatter'
        }, {
            field: 'interrupt',
            title: '故障中断',
            align: 'center',
            formatter: 'cellInterruptFormatter'
        }, {
            field: 'id',
            title: '',
            //checkbox: true
            visible: false
        }]
        ,
        onClickCell: function (field, value, row, $element) {
            console.log(field);
            console.log(value);
            console.log(row);
            console.log($element);
            if (field == "interrupt") {
                var interrupt = !value;
                master.postJSON({
                    url: "/source/editInterrupt",
                    data: {
                        id: row['id'],
                        interrupt: interrupt
                    },
                    complete: function (data) {
                        //data = JSON.parse(data);
                        if (data == "success") {
                            $('#dataSourceTable').bootstrapTable('refresh');
                        }
                    }
                });
            }
        }
    });
}
function initDetailTable() {
    $('#detialTable').bootstrapTable({
        url: 'data_source_table.json',
//            classes: 'table table-bordered',
        height: '300',
        sidePagination: 'client',
        columns: [{
            field: 'id',
            title: '名称',
            visible: false
        }, {
            field: 'column',
            title: '名称',
            align: 'center'
        }, {
            field: 'status',
            title: '状态',
            align: 'center'
        }]
    });
}

function showAddModal() {
    $('#addModal').modal();
}

function initValidator() {
    // 添加数据源Form前端验证
    $('#addSourceForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            alias: {
                validators: {
                    stringLength: {
                        min: 6,
                        max: 20,
                        message: '数据源名称长度为6~20位'
                    },
                    notEmpty: {
                        message: '数据源名称不能为空'
                    }
                }
            },
            ip: {
                validators: {
                    ip: {
                        message: 'IP格式错误'
                    },
                    notEmpty: {
                        message: 'IP不能为空'
                    }
                }
            },
            port: {
                validators: {
                    between: {
                        min: 0,
                        max: 65535,
                        message: '端口范围为0~65535'
                    },
                    notEmpty: {
                        message: '端口不能为空'
                    }
                }
            },
            type: {
                validators: {
                    notEmpty: {
                        message: '类型不能为空'
                    }
                }
            },
            sid: {
                validators: {
                    notEmpty: {
                        message: '缺省SID不能为空'
                    }
                }
            }
        }
    });

    // DBA授权Form前端验证
    $('#authForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            dbaName: {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    }
                }
            },
            dbaPassword: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    });
}

/**
 *  故障中断单元格样式
 */
function cellInterruptFormatter(value, row, index) {
    if (value) {
        return "<a onclick='changeInterrupt(this)'><i class=\"glyphicon glyphicon-ok\" style=\"color: green;\"></a>";
    } else {
        return "<a onclick='changeInterrupt(this)'><i class=\"glyphicon glyphicon-remove\" style=\"color: red;\"></a>";
    }
}

function cellStatusFormatter(value, row, index) {
    if (value) {
        return "<span style=\"color: green;\">已部署</span>";
    } else {
        return "<span style=\"color: red;\">未部署</span>";
    }
}

/**
 *
 */
function submitAddSource() {
    master.postJSON({
        url: "/source/add",
        data: $('#addSourceForm').serialize(),
        complete: function (data) {
            data = JSON.parse(data);
            if (data.success == "success") {
                $('#addModal').modal('hide');
                $('#dataSourceTable').bootstrapTable('refresh');
            } else {
                alert("添加数据源失败");
            }
        }
    })
}

/**
 * 点击删除按钮响应事件
 */
function delDataSource() {
    // 获取选中数据源id
    var id = getSelectedRowId();
    if (id == false) {
        return;
    }
    master.postJSON({
        url: "/source/del",
        data: {
            id: id,
        },
        complete: function () {
            $('#dataSourceTable').bootstrapTable('refresh');
        }
    });
}

/**
 * 点击编辑按钮响应事件
 */
function editDataSource() {
    // 获取选中数据源id
    var id = getSelectedRowId();
    if (id == false) {
        return;
    }
    master.postJSON({
        url: "/source/getById",
        data: {
            id: id,
        },
        complete: function (data) {
            data = JSON.parse(data);
            $('#alias').val(data['alias']);
            $('#ip').val(data['ip']);
            $('#port').val(data['port']);
            $('#type').val(data['type']).trigger("change");
            $('#sid').val(data['sid']);
            $('#id').val(data['id']);
            $('#addModal').modal();
        }
    });
}

/**
 * 获取选中行的id,没选中返回false并提示
 * @returns {*}
 */
function getSelectedRowId() {
    var selectedRows = $('#dataSourceTable').bootstrapTable('getSelections');
    if (selectedRows.length == 0) {
        alert("请选择一项");
        return false;
    }
    return selectedRows[0]['id'];
}

/**
 * 授权操作
 */
function authDBA() {

}