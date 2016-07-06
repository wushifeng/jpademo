<%--
  Created by IntelliJ IDEA.
  User: Answer
  Date: 16/7/1
  Time: 上午9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">数据源管理</div>
            <div class="panel-body">
                <table id="dataSourceTable"></table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">安全域</div>
            <div class="panel-body">
                <div class="panel panel-primary col-lg-3" style="height:300px;overflow:auto; padding-top: 10px">
                    <div id="showEncryptTree" class="schema-tree"></div>
                </div>
                <div class="col-lg-9">
                    <table id="showEncryptTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="toolbar2">
    <div class="btn-group">
        <button id="encrypt" onclick="showEncryptModal()" class="btn btn-outline btn-default btn-sm">
            <i class="glyphicon glyphicon-plus"></i>
            新建加密
        </button>
        <button id="unencrypt" onclick="showUnEncryptModal()" class="btn btn-outline btn-default btn-sm">
            <i class="glyphicon glyphicon-edit"></i>
            新建解密
        </button>
    </div>
    <div class="btn-group">
        <button id="cjlh" class="btn btn-outline btn-default btn-sm">
            创建轮换
        </button>
    </div>
    <div class="btn-group">
        <button id="taskList" class="btn btn-outline btn-default btn-sm" onclick="$('#authModal').modal()">
            任务列表
        </button>
    </div>
</div>
<!-- 新建加密modal框-->
<div class="modal fade" id="encryptModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 id="encryptModalTitle" class="text-center text-primary">新建加密</h4>
            </div>
            <div class="modal-body" style="height: 400px;">
                <div class="panel panel-primary col-lg-4" style="height: 350px;overflow:auto; padding-top: 10px">
                    <div id="addEncryptTree" class="schema-tree"></div>
                </div>
                <div class="panel col-lg-8" style="padding-bottom: 30px">
                    <table id="addEncryptTable"></table>
                    <br/>
                    <br/>
                    <br/>
                    <button type="submit" class="btn btn-primary btn-block">添加到任务列表</button>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script src="/static/js/encrypt.js"></script>
<script>
    $(document).ready(function () {
        initEncryptPage();
    });
</script>
</body>
</html>
