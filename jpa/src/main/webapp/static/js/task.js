/**
 * Created by Answer on 16/7/1.
 */
function initTaskPage() {
    initTable();
}
function initTable() {
    $('#table').bootstrapTable({
        url: 'data_source_table.json',
//            height: '300',
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
            visible: false
        }, {
            field: 'taskName',
            title: '任务名称',
            align: 'center'
        }, {
            field: 'progress',
            title: '进度',
            align: 'center',
            formatter: 'formatterProgress'
        }, {
            field: 'dataSourceName',
            title: '数据源名称',
            align: 'center'
        }, {
            field: 'startTime',
            title: '执行时间',
            align: 'center'
        }, {
            field: 'ip',
            title: 'IP',
            align: 'center'
        }, {
            field: 'status',
            title: '操作',
            align: 'center',
            width: '200',
            formatter: 'commonFormatter'
        }]
    });
}

function commonFormatter(value) {
    var start = "";
    var stop = "";
    if (value) {
        start = "style=\"color:green\""
        stop = "style=\"color:red\""
    } else {
        start = "style=\"color:red\""
        stop = "style=\"color:green\""
    }
    return "<a><span class=\"glyphicon glyphicon-play\" " + start +
        "></span></a> &nbsp&nbsp&nbsp&nbsp&nbsp" +
        "<a><span class=\"glyphicon glyphicon-pause\" " + stop +
        "></span></a>&nbsp&nbsp&nbsp&nbsp&nbsp" +
        "<a><span class=\"glyphicon glyphicon-remove \"></span></a>";
}

function formatterProgress(value) {
    a = '<div class="progress">' +
        '<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="' + value + '" aria-valuemin="0" aria-valuemax="100" style="width: ' + value + '%">' +
        '<span class="">' + value + '%</span>' +
        '</div>' +
        '</div>';
    return a;
}