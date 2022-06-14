<%-- 
    Document   : productView
    Created on : Jun 9, 2022, 8:11:17 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <f:form action="saveProduct.htm" method="post" commandName="product" >
            <label>Product Id</label>
            <br>
            <c:if test="${isInsert}">
                <f:input path="productId"></f:input>
                    <input name="isInsert" value="true" type="hidden">
            </c:if>
            <c:if test="${!isInsert}">
                <f:input path="productId" readonly="true"></f:input>
                    <input name="isInsert" value="false" type="hidden">
            </c:if>
            <br>
            <label>Product Name</label>
            <br>
            <f:input path="productName"></f:input>
                <br>
                <label>Price</label>
                <br>
            <f:input path="price"></f:input>
                <br>
                <label>Date Release</label>
                <br>
            <f:input path="dateRelease"></f:input>
                <br>
                <label>Branch</label>
                <br>
            <f:input path="branch"></f:input>
                <br>
                <label>Status</label>
                <br>
            <f:checkbox path="status"></f:checkbox>
                <br>
                <button type="submit">Save</button>
        </f:form>
    </body>
</html>
