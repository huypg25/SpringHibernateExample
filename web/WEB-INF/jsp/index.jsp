<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form action="listProducts.htm" method="get">
            <input name="keyword">
            <button>Search</button>
        </form>
        <a href="openForm.htm">Add new product</a>
        <table border>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Date Release</th>
                <th>Branch</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="product" items="${listProducts}">
                <tr>
                    <th>${product.productId}</th>
                    <th>${product.productName}</th>
                    <th>${product.price}</th>
                    <th>${product.dateRelease}</th>
                    <th>${product.branch}</th>
                    <th>${product.status?"Active":"Not-active"}</th>
                    <th>
                        <a href="get-product-by-id.htm?productId=${product.productId}">Update</a>
                        <a href="deleteProduct.htm?productId=${product.productId}">Delete</a>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
