<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleEF.css"%></style>
<html lang="pl-PL">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<h1>Add New Employee</h1>
<form:form method="post" action="save">
    <table cellspacing="5" cellpadding="5">
        <form:hidden path="id" />
        <tr>
            <td>First Name : </td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td><form:input path="salary" /></td>
        </tr>
            <td>Address :</td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td>City :</td>
            <td><form:input path="city" /></td>
        </tr>
        <tr>
            <td>Age :</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td>Benefit :</td>
            <td><form:input path="benefit" /></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><form:input type="email" path="email"/></td>
        </tr>
        <tr>
            <td>StartJobDate : dd/mm/yyyy</td>
            <td><form:input path="startJobDate"/></td>
        </tr>

        <tr>
            <td colspan="2" width="100%"><input type="submit" value="Save" />
            </td>
        </tr>
        <tr>
            <td colspan="2" width="100%"><form:form method="get" action="db">
                <input type="submit" value="db"/>
            </form:form></td>
        </tr>
    </table>
</form:form>

</html>

