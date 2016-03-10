<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cagatay.gokcel
  Date: 19.2.2016
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
  <style type="text/css">
    [ng\:cloak], [ng-cloak], .ng-cloak {
      display: none !important;
    }
  </style>
</head>

<body ng-app="CMApp">
<div>
  <h1>Greeting</h1>
  <div ng-controller="HomeController" ng-cloak class="ng-cloak">
    <p>The ID is {{greeting.id}}</p>
    <p>The content is {{greeting.content}}</p>
  </div>
</div>
<c:set var="commonResourcePath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}" />
<script src="<c:url value='${commonResourcePath}/resources/angular.min.js' />"></script>
<script src="<c:url value='${commonResourcePath}/angular/src/app.js' />"></script>
<script src="<c:url value='${commonResourcePath}/angular/src/services/CustomerService.js' />"></script>
<script src="<c:url value='${commonResourcePath}/angular/src/controllers/CustomerController.js' />"></script>
</body>


</html>
