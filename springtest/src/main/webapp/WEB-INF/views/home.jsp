<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kenfor
  Date: 2019/6/18
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css"/>">
  </head>
  <body>
    <h1>Welcome to Spittr</h1>
    <a href="<c:url value="/spittles"/>">Spittles</a>
    <a href="<c:url value="/spitter/register"/>">Register</a>
  </body>
</html>