/**
 * Created by Answer on 16/6/29.
 */

function initSourcePage() {
    // 改变导航栏状态
    $('#nav-datasource').addClass('active');
    initEditDataSourceTable($('#dataSourceTable'));
    //initDetailTable();
    initEncryptTable($('#detialTable'), false);
    initSchemaTree($('#schemaTree'), $('#detialTable'));
    initValidator();
    $("#type").select2({
        minimumResultsForSearch: Infinity,
        data: Global.DBTypt
    });
}

function showAddModal() {
    // 修改模态框标题
    $('#addModalTitle').text("添加数据源")
    $('#addModal').modal();
}

/**
 * 前端验证
 */
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
 * 提交添加数据源响应事件
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

            // 修改模态框标题
            $('#addModalTitle').text("编辑数据源");
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