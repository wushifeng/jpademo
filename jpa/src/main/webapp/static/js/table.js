/**
 * Created by Answer on 16/7/6.
 */

/**
 * 初始化可编辑的数据源Table
 * @param table
 */
function initEditDataSourceTable(table) {
    table.bootstrapTable({
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
                            table.bootstrapTable('refresh');
                        }
                    }
                });
            }
        }
    });
}

/**
 * 初始化只展示的数据源Table
 * @param table
 */
function initShowDataSourceTable(table) {
    table.bootstrapTable({
        url: '/source/get',
        height: '300',
//            showRefresh: true,
        pagination: true,
        pageNumber: '1',
        sidePagination: 'server',
//            toolbar: '#toolbar',
        queryParamsType: 'size',
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
            field: 'sid',
            title: '实例',
            align: 'center'
        }]
    });
}

/**
 * 初始化安全域表信息Table
 * 添加解密模态框中的Table
 * @param table
 */
function initEncryptTableInModal(table) {
    table.bootstrapTable({
        url: 'data_source_table.json',
        classes: 'table table-no-bordered',
        height: '250',
        singleSelect: true,
        clickToSelect: true,
        sidePagination: 'client',
        columns: [{
            title: '',
            checkbox: true
        }, {
            field: 'column',
            title: '名称',
            align: 'center'
        }, {
            field: 'status',
            title: '状态',
            align: 'center'
        }, {
            field: 'algorithm',
            title: '加密算法',
            align: 'center',
            formatter: 'cellEditEncryptAlgorithm'
        }, {
            field: 'id',
            title: '',
            visible: false
        }]
    });
}

/**
 * 初始化安全域表信息Table
 * 加密解密页面中的表信息Table
 * @param table
 */
function initEncryptTable(table, isShowAlgorithm) {
    table.bootstrapTable({
        height: '300',
        sidePagination: 'client',
        toolbar: '#toolbar2',
        columns: [{
            field: 'column',
            title: '名称',
            align: 'center'
        }, {
            field: 'status',
            title: '状态',
            align: 'center'
        }, {
            field: 'algorithm',
            title: '加密算法',
            align: 'center',
            formatter: 'cellEncryptAlgorithm',
            visible: isShowAlgorithm
        }, {
            field: 'id',
            title: '名称',
            visible: false
        }]
    });


}
