<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleEF.css"%></style>
<html lang="pl-PL">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<h1>Add New Printer</h1>
<form:form method="post" action="savePrinter">
    <table class="printerform" cellspacing="5" cellpadding="5">
        <form:hidden path="id" />
        <tr>
            <td>Name : </td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>EmployeesByID :</td>
            <c:forEach var="employees" items="${list}">
        <tr>
            <td>${employees.id}</td>
            <td>${employees.firstName} ${employees.lastName}</td>
            <td>${employees.salary}</td>

            <td>
                <form:form method="post" action="deletePrinter">
                    <input type="hidden" id="id" name="id" value="${printer.id}"/>
                    <input type="submit" class="button" name="Delete" value="delete"/>
                </form:form>
                <form:form method="post" action="editPrinter">
                    <input type="hidden" id="id" name="id" value="${printer.id}"/>
                    <input type="submit" class="button" name="Edit" value="edit"/>
                </form:form>
            </td>
        </tr>
        </c:forEach>
        </tr>

        <tr>
            <td class="lastPrinter" colspan="2" width="100%"><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</html>