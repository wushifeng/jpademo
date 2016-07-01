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
                <table id="table"></table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">安全域</div>
            <div class="panel-body">
                <div class="panel panel-primary col-lg-3" style="height:300px;overflow:auto; padding-top: 10px">
                    <div id="tree2" class="schema-tree"></div>
                </div>
                <div class="col-lg-9">
                    <table id="table3"></table>
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
        <button id="unencrypt" class="btn btn-outline btn-default btn-sm">
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

<!-- 添加数据源modal框-->
<div class="modal fade" id="addModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="text-center text-primary">添加数据源</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addSourceForm">
                    <fieldset>
                        <div class="form-group">
                            <label for="alias" class="col-sm-3 control-label">名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="alias" name="alias">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ip" class="col-sm-3 control-label">IP</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="ip" name="ip">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="port" class="col-sm-3 control-label">端口</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="port" name="port">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="type" class="col-sm-3 control-label">类型</label>
                            <div class="col-sm-8">
                                <!--<input type="password" class="form-control" id="type" name="type">-->
                                <select class="form-control" id="type" name="type">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sid" class="col-sm-3 control-label">缺省SID</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control" id="sid" name="sid">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-9 col-sm-2">
                                <button type="submit" class="btn btn-success btn-block">确定</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- 授权modal框-->
<div class="modal fade" id="authModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="text-center text-primary">授权</h4>
            </div>
            <div class="modal-body">
                <form id="authForm">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="DBA用户名" name="dbaName" type="text" autofocus>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="DBA密码" name="dbaPassword" type="password"
                                   value="">
                        </div>
                        <!-- Change this to a button or input when using this as a form -->
                        <button type="submit" onclick="authDBA()" class="btn btn-lg btn-success btn-block">授权
                        </button>
                    </fieldset>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- 新建加密modal框-->
<div class="modal fade" id="encryptModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="text-center text-primary">添加数据源</h4>
            </div>
            <div class="modal-body" style="height: 400px;">
                <div class="panel panel-primary col-lg-4" style="height: 350px;overflow:auto; padding-top: 10px">
                    <div id="tree" class="schema-tree"></div>
                </div>
                <div class="panel col-lg-8" style="padding-bottom: 30px">
                    <table id="table2"></table>
                    <!--<h4>-->
                    <!--</h4>-->
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
