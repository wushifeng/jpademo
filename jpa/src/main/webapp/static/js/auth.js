/**
 * Created by Answer on 16/7/1.
 */
function initAuthPage() {
    // 改变导航栏状态
    $('#nav-auth').addClass('active');
    initShowDataSourceTable($('#dataSourceTable'));
    initUserTable();
    initSchemaTree($('#schemaTree'));
    initValidator();
    $("#switch-offText").bootstrapSwitch({
        size: 'mini',
        onColor: 'primary',
        offColor: 'danger',
        onText: '启用',
        offText: '停止'
    });
}

function initUserTable() {
    $('#userTable').bootstrapTable({
        url: 'data_source_table.json',
        classes: 'table table-no-bordered',
        height: '200',
//            showRefresh: true,
//            pagination: true,
//            pageNumber: '1',
        sidePagination: 'client',
//            toolbar: '#toolbar',
        singleSelect: true,
        clickToSelect: true,
        columns: [{
            field: 'id',
            title: '',
            checkbox: true
        }, {
            field: 'name',
            title: '用户名',
            align: 'center'
        }, {
            field: 'select',
            title: '查询',
            align: 'center',
            formatter: 'commonFormatter'
        }, {
            field: 'insert',
            title: '添加',
            align: 'center',
            formatter: 'commonFormatter'
        }, {
            field: 'update',
            title: '修改',
            align: 'center',
            formatter: 'commonFormatter'
        }, {
            field: 'delete',
            title: '删除',
            align: 'center',
            formatter: 'commonFormatter'
        }]
    });
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
                        message: '缺省SID不能为空'
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

function commonFormatter(value) {
    if (value) {
        return "<a><span class=\"glyphicon glyphicon-ok \" style=\"color:black\"></span></a>";
    } else {
        return "<a><span class=\"glyphicon glyphicon-remove\" style=\"color:red\"></span></a>";
    }
}