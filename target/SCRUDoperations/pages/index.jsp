<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.12.2019
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="page_components/imports.jsp"></c:import>
    <title>CRUD operations</title>
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <div class="jumbotron" id="index_jumbotron">
                <div class="text-center"><h1>CRUD operations</h1></div>
                <p class="lead text-center text-nowrap">CRUD is the 4 basic operations of data management: create, read,
                    update, delete</p>
            </div>
            <!--/.jumbotron -->
            <div class="cols">
                <div class="row">
                    <div class="col-lg-4">
                        <img class="img-rounded" src="${pageContext.request.contextPath}/resources/img/jdbc.png"
                             alt="jdbc logo" width="140" height="140">
                        <p>Java Database Connectivity (JDBC) is an application programming interface (API) for the
                            programming language Java, that defines how a client may access a database.</p>
                        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/jdbc" role="button">View
                            JDBC &raquo;</a></p>
                    </div>
                    <div class="col-lg-4">
                        <img class="img-rounded" src="${pageContext.request.contextPath}/resources/img/hiber.png"
                             alt="hibernate logo" width="140" height="140">
                        <p>Hibernate ORM is framework for the Java language. It provides a framework for mapping an
                            object-oriented domain model to a relational database.</p>
                        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/hibernate" role="button">View
                            Hibernate&raquo;</a></p>
                    </div>
                    <div class="col-lg-4">
                        <img class="img-rounded" src="${pageContext.request.contextPath}/resources/img/jpa.png"
                             alt="hibernate logo" width="140" height="140">
                        <p>The Java Persistence API (JPA) is a Java API specification that describes the management of
                            relational data in applications using Java SE and Java EE.</p>
                        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/jpa" role="button">View
                            JPA &raquo;</a></p>
                    </div>
                </div>
            </div>
            <!--/.cols -->
        </div>
    </div>
    <!--/.row -->
</div>
<!--/.container -->
</body>
</html>
