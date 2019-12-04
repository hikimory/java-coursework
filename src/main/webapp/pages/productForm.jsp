<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.12.2019
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="page_components/imports.jsp"></c:import>
    <title>${title}</title>
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${action} product <small>using ${title}</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="product" class="form-horizontal">
                        <form:hidden path="idProduct"/>
                        <div class="form-group">
                            <label for="productName" class="col-sm-3 control-label">Product name:</label>
                            <div class="col-sm-9">
                                <form:input path="productName" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="manufacturer" class="col-sm-3 control-label">Manufacturer:</label>
                            <div class="col-sm-9">
                                <form:input path="manufacturer" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
