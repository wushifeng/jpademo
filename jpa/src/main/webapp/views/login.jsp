<%--
  Created by IntelliJ IDEA.
  User: Answer
  Date: 16/6/27
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>数据库安全管理门户</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-2 col-md-offset-3">
            <button type="button" class="btn btn-lg btn-success btn-block" user-role="1" onclick="openLoginModal(this)">
                <br/>系统管理员<br/><br/></button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-lg btn-success btn-block" user-role="2" onclick="openLoginModal(this)">
                <br/>安全管理员<br/><br/></button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-lg btn-success btn-block" user-role="3" onclick="openLoginModal(this)">
                <br/>审计管理员<br/><br/></button>
        </div>
    </div>
</div>

<!-- 登录model框-->
<div class="modal fade" id="loginModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h3 id="loginText" class="text-center text-primary">登录</h3>
            </div>
            <div class="modal-body">
                <form id="loginForm">
                    <fieldset>
                        <div class="form-group">
                            <input id="name" class="form-control" placeholder="用户名" name="name" type="text"
                                   autofocus>
                        </div>
                        <div class="form-group">
                            <input id="password" class="form-control" placeholder="密码" name="password" type="password"
                                   value="">
                        </div>
                        <!-- Change this to a button or input when using this as a form -->
                        <button type="button" onclick="login()" class="btn btn-lg btn-success btn-block">登录</button>
                    </fieldset>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script src="/static/js/master.js"></script>
<script src="/static/js/login.js"></script>
<script>
    $(document).ready(function () {
        initValidator();
    });


</script>
</body>
</html>

