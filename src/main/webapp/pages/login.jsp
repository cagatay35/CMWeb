<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
</head>
<body>
<spring:url value="/user/login" var="loginUrl"/>
<div>Hello this is ${name}</div>
<form:form action="${loginUrl}" method="post">
    <div>
        Username : <input type="text" id="itUserName" name="itUserName">
        Password : <input type="password" id="itPassword" name="itPassword">
        <button type="submit" id="btnLogin">Login</button>
    </div>
</form:form>

</body>
</html>
