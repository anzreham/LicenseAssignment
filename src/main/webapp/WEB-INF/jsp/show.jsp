<%--
  Created by IntelliJ IDEA.
  User: great
  Date: 1/12/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/songs">Dashboard</a>
</nav>
<div>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <h1><c:out value=""/> ${p.firstName} ${p.lastName}</h1>
    <p>artist: <c:out value=""/>  State: ${p.license.state} </p>
    <p>artist: <c:out value=""/>  Number: ${p.license.number} </p>



</div>
</body>
</html>
