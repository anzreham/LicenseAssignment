
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Welcome User</h1>
    </div>

    <div >

        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <h1>New Book</h1>
        <form:form action="/persons" method="post" modelAttribute="person">

            <p>
                <form:label path="firstName">firstName</form:label>
                <form:errors path="firstName"/>
                <form:input path="firstName"/>
            </p>
            <p>
                <form:label path="lastName">lastName</form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </p>


            <input type="submit" value="Submit"/>
        </form:form>


    </div>
</div>
</body>
</html>
