/**
 * Created by Answer on 16/6/29.
 */

function initSourcePage() {
    // 改变导航栏状态
    $('#nav-datasource').addClass('active');
    initTable();
    initDetailTable();
    initSchemaTree();
    initValidator();
    $("#type").select2({
        minimumResultsForSearch: Infinity,
        data: [
            {
                id: 'value',
                text: 'Text to display'
            },
            {
                id: '2',
                text: 'orcl'
            }
        ]
    });
}
function initTable() {
    $('#dataSourceTable').bootstrapTable({
        url: 'data_source_table.json',
        height: '300',
        showRefresh: true,
        pagination: true,
        pageNumber: '1',
        sidePagination: 'client',
        toolbar: '#dataSourceTableToolbar',
        singleSelect: true,
        clickToSelect: true,
        columns: [{
            field: 'id',
            title: '',
            checkbox: true
        }, {
            field: 'alias',
            title: '名称',
            align: 'center'
        }, {
            field: 'type',
            title: '数据类型',
            align: 'center'
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
            align: 'center'
        }, {
            field: 'isInterrupt',
            title: '故障中断',
            align: 'center'
//                checkbox: true
        }]
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
            field: 'alias',
            title: '名称',
            align: 'center'
        }, {
            field: 'status',
            title: '状态',
            align: 'center'
        }]
    });
}
function initSchemaTree() {
    $('#schemaTree').treeview({
        color: "#428bca",
        nodeIcon: 'glyphicon glyphicon-bookmark',
        data: [
            {
                text: 'Parent 1',
                href: '#parent1',
                tags: ['4'],
                nodes: [
                    {
                        text: 'Child 1',
                        href: '#child1',
                        tags: ['2'],
                        nodes: [
                            {
                                text: 'Grandchild 1',
                                href: '#grandchild1',
                                tags: ['0']
                            },
                            {
                                text: 'Grandchild 2',
                                href: '#grandchild2',
                                tags: ['0']
                            }
                        ]
                    },
                    {
                        text: 'Child 2',
                        href: '#child2',
                        tags: ['0']
                    }, {
                        text: 'Child 1',
                        href: '#child1',
                        tags: ['2'],
                        nodes: [
                            {
                                text: 'Grandchild 1',
                                href: '#grandchild1',
                                tags: ['0']
                            },
                            {
                                text: 'Grandchild 2',
                                href: '#grandchild2',
                                tags: ['0']
                            }
                        ]
                    }, {
                        text: 'Child 1',
                        href: '#child1',
                        tags: ['2'],
                        nodes: [
                            {
                                text: 'Grandchild 1',
                                href: '#grandchild1',
                                tags: ['0']
                            },
                            {
                                text: 'Grandchild 2',
                                href: '#grandchild2',
                                tags: ['0']
                            }
                        ]
                    }, {
                        text: 'Child 1',
                        href: '#child1',
                        tags: ['2'],
                        nodes: [
                            {
                                text: 'Grandchild 1',
                                href: '#grandchild1',
                                tags: ['0']
                            },
                            {
                                text: 'Grandchild 2',
                                href: '#grandchild2',
                                tags: ['0']
                            }
                        ]
                    }
                ]
            }
        ]
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
/**
 * 授权操作
 */
function authDBA() {

}