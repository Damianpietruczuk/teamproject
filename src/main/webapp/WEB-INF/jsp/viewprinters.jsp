<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleVE.css"%></style>
<html lang="pl-PL">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body>
<h1>View Printers List</h1>
<table border="2" width="70%" cellspacing="10" cellpadding="10" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="printer" items="${list}">
        <tr>
            <td>${printer.id}</td>
            <td>${printer.name}</td>

            <td>
                <form:form method="post" action="deletePrinter">
                    <input type="hidden" id="id" name="id" value="${printer.id}"/>
                    <input type="submit" class="button" name="Delete" value="delete"/>
                </form:form>
                <form:form method="post" action="editPrinter">
                    <input type="hidden" id="id" name="id" value="${printer.id}"/>
                    <input type="submit" class="button" name="Edit" value="edit"/>
                </form:form>
                <form:form method="post" action="show">
                    <input type="hidden" id="id" name="id" value="${printer.id}"/>
                    <input type="submit" class="button" name="Show" value="show"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>
    <a href="/">Main menu</a>
</table>
</body>
</html>