<%--
  Created by IntelliJ IDEA.
  User: Answer
  Date: 16/7/1
  Time: 上午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据库安全管理门户</title>
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
            <div class="panel-heading">表详细</div>
            <div class="panel-body">
                <div class="panel panel-primary col-lg-3" style="height:400px;overflow:auto; padding-top: 10px">
                    <div id="schemaTree"></div>
                </div>
                <div class="col-lg-9">
                    <div class="panel panel-default">
                        <div class="panel-heading">授权</div>
                        <table id="userTable"></table>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">限制</div>
                        <div class="panel-body">
                            <form class="form-horizontal" id="limitForm">
                                <fieldset>
                                    <div class="form-group">
                                        <label for="appName" class="col-sm-2 control-label">程序名</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="appName" name="appName">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ipStart" class="col-sm-2 control-label">IP地址范围</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="ipStart" name="ipStart">
                                        </div>
                                        <div class="col-sm-1"><label class="control-label">至</label></div>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="ipEnd" name="ipEnd">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="timeStart" class="col-sm-2 control-label">时间点范围</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="timeStart" name="timeStart">
                                        </div>
                                        <div class="col-sm-1"><label class="control-label">至</label></div>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="timeEnd" name="timeEnd">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="weekStart" class="col-sm-2 control-label">星期范围</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="weekStart" name="weekStart">
                                        </div>
                                        <div class="col-sm-1"><label class="control-label">至</label></div>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="weekEnd" name="weekEnd">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">访问审计</label>
                                        <div class="checkbox col-sm-9">
                                            <input id="switch-offText" type="checkbox">
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/auth.js"></script>
<script>
    $(document).ready(function () {
        initAuthPage();
    });
</script>
</body>
</html>
