<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleVE.css"%></style>
<html lang="pl-PL">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body>
<h1>View Employees List</h1>
<table border="2" width="70%" cellspacing="10" cellpadding="10" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.firstName} ${emp.lastName}</td>
            <td>${emp.salary}</td>

            <td>
                <form:form method="post" action="delete">
                    <input type="hidden" id="id" name="id" value="${emp.id}"/>
                    <input type="submit" class="button" name="Delete" value="delete"/>
                </form:form>
                <form:form method="post" action="edit">
                    <input type="hidden" id="id" name="id" value="${emp.id}"/>
                    <input type="submit" class="button" name="Edit" value="edit"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>

    <td colspan="4" width="100%"><span>
        <form:form method="post" action="test">
            <input type="submit" class="button" name="test" value="test"/>
        </form:form>
        </span>
    </td>

</table>
</body>
</html>