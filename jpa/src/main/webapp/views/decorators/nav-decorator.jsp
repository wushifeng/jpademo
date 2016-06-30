<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>
        <sitemesh:write property='title'/>
        - ltcms
    </title>
    <!-- Bootstrap Core CSS -->
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="/static/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/static/sbAdmin/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!--Validator-->
    <link rel="stylesheet" href="/static/validator/css/bootstrapValidator.css"/>
    <!-- Bootstrap Table-->
    <link rel="stylesheet" href="../static/table/css/bootstrap-table.min.css">
    <!-- Tree View-->
    <link rel="stylesheet" href="../static/treeview/css/bootstrap-treeview.min.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]-->
    <script src="/static/bootstrap/js/html5shiv.min.js"></script>
    <script src="/static/bootstrap/js/respond.min.js"></script>

    <!-- jQuery -->
    <script src="/static/bootstrap/js/jquery.min.js"></script>
    <![endif]-->

    <sitemesh:write property='head'/>
</head>

<body style="padding-top: 60px">

<div id="wrapper">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
        <!--Logo-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>
        <!-- 导航菜单 -->
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">数据源 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">加密解密</a></li>
            <li><a href="#">任务</a></li>
            <li><a href="#">授权</a></li>
        </ul>
        <ul class="nav navbar-top-links navbar-right">
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i>用户信息</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i>退出</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->
    </nav>
</div>
<sitemesh:write property='body'/>

<!-- Bootstrap Core JavaScript -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="/static/metisMenu/dist/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/static/sbAdmin/js/sb-admin-2.js"></script>
<!-- Validator -->
<script type="text/javascript" src="/static/validator/js/bootstrapValidator.js"></script>
<!--Bootstrap Table-->
<script src="../static/table/js/bootstrap-table.min.js"></script>
<script src="../static/table/js/bootstrap-table-zh-CN.min.js"></script>
<!--Tree View-->
<script src="../static/treeview/js/bootstrap-treeview.min.js"></script>
</body>
</html>
