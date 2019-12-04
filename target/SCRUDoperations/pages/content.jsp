<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.12.2019
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="page_components/imports.jsp"></c:import>
    <title>CRUD - ${title}</title>
</head>
<c:import url="page_components/header.jsp"></c:import>
<div class="container">
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${title}<small> crud operations</small></h1>
                    </div>
                </div>
                <div class="alert alert-info" role="alert">
                    <a class="btn btn-primary" role="button"
                       href="${pageContext.request.contextPath}/${instrument}/pdfReport?view=pdfView" target="_blank">Download
                        PDF report</a>
                    <a class="btn btn-primary" role="button"
                       href="${pageContext.request.contextPath}/${instrument}/xlsxReport.xlsx?view=excelView"
                       target="_blank">Download Excel report</a>
                </div>
                <div class="panel-body">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Products</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-brands">
                            <thead>
                            <th>
                                <button class="sort" data-sort="brand-name">productName</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="founded-year">manufacturer</button>
                            </th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="product" items="${listProduct}" varStatus="status">
                                <tr>
                                    <td class="brand-name">${product.productName}</td>
                                    <td class="founded-year">${product.manufacturer}</td>
                                    <td class="action">
                                        <a href="${pageContext.request.contextPath}/${instrument}/edit-product/${product.idProduct}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/${instrument}/delete-product/${product.idProduct}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button"
                                                     href="${pageContext.request.contextPath}/${instrument}/newProduct">Add
                            new Product &raquo</a></div>
                    </div>

                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Order</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-models">
                            <thead>
                            <th>
                                <button class="sort" data-sort="brand-name">productName</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="model-name">productCount</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="generation">price</button>
                            </th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="order" items="${listOrder}" varStatus="status">
                                <tr>
                                    <td class="brand-name">${order.product.productName}</td>
                                    <td class="model-name">${order.productCount}</td>
                                    <td class="generation">${order.price}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/${instrument}/edit-order/${order.idOrder}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/${instrument}/delete-order/${order.idOrder}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button"
                                                     href="${pageContext.request.contextPath}/${instrument}/newOrder">Add
                            new Order &raquo</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/list.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/content-list.js"></script>
</body>
</html>
