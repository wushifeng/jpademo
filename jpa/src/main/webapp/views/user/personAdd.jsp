<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>userInfo</title>
</head>
<body>
<div class="col-sm-1">
</div>

<div class="col-sm-10">
    <h2>人员测试</h2>
    
    <form:form commandName="personForm" method="post" action="savePerson" id="personForm" autocomplete="off">
         
		<br />
		姓名:
		
		<form:input path="firstName" required="required"/>
		<font color="#FF0000"> <form:errors path="firstName"/></font>
		<br />
		<br />
		年龄:
				<form:input path="age" required="required"/>    
				<font color="#FF0000"> <form:errors path="age"/></font>
		<br />
		<br />
		
		<br />
		<br />
        <fieldset class="form-actions">
            <button type="submit"  name="save" onclick="bCancel=false">
                保存
            </button>
            <button type="submit"  name="cancel" onclick="location.href='javascript:history.go(-1);'">
                取消
            </button>
        </fieldset>
    </form:form>
</div>
</body>
</html>
