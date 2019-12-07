<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleEF.css"%></style>
<html lang="pl-PL">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<h1>Display Employee Full Data</h1>
<form:form>
    <table cellspacing="5" cellpadding="5">
        <form:hidden path="id" />
        <tr>
            <td>First Name : </td>
            <td><form:input type="" path="firstName" readonly="true"/></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><form:input path="lastName" readonly="true"/></td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td><form:input path="salary" readonly="true"/></td>
        </tr>
        <tr>
            <td>Address :</td>
            <td><form:input path="address" readonly="true"/></td>
        </tr>
        <tr>
            <td>City :</td>
            <td><form:input path="city" readonly="true"/></td>
        </tr>
        <tr>
            <td>Age :</td>
            <td><form:input path="age" readonly="true"/></td>
        </tr>
        <tr>
            <td>Benefit :</td>
            <td><form:input path="benefit" readonly="true"/></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><form:input path="email" readonly="true"/></td>
        </tr>
        <tr>
            <td>StartJobDate :</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2" width="100%"><a href="viewemp">Back to view employees</a></td>
        </tr>
    </table>
</form:form>
</html>