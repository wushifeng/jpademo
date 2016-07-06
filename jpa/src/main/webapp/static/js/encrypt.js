/**
 * Created by Answer on 16/7/1.
 */
function initEncryptPage() {
    // 改变导航栏状态
    $('#nav-encrypt').addClass('active');
    initShowDataSourceTable($('#dataSourceTable'));
    initEncryptTable($('#showEncryptTable'), true);
    initSchemaTree($('#showEncryptTree'), $('#showEncryptTable'));
    initValidator();
}

function showAddModal() {
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

function showEncryptModal() {
    // 修改模态框标题
    $('#encryptModalTitle').text("新建加密")
    initEncryptTableInModal($('#addEncryptTable'));
    initSchemaTree($('#addEncryptTree'), $('#addEncryptTable'));
    $('#encryptModal').modal();
}

function showUnEncryptModal() {
    // 修改模态框标题
    $('#encryptModalTitle').text("新建解密");
    initEncryptTableInModal($('#addEncryptTable'));
    initSchemaTree($('#addEncryptTree'), $('#addEncryptTable'));
    $('#encryptModal').modal();

}