<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleEF.css"%></style>
<html lang="pl-PL">
<h1>Display Printer Full Data</h1>
<form:form>
    <table cellspacing="5" cellpadding="5">
        <form:hidden path="id" />
        <tr>
            <td>First Name : </td>
            <td><form:input type="" path="name" readonly="true"/></td>
        </tr>
        <tr>
            <td>Employees :</td>
            <td><form:input path="employees" readonly="true"/></td>
        </tr>

        <tr>
            <td class="last" colspan="2" width="100%"><a href="viewprinters">Back to view printers</a></td>
        </tr>
    </table>
</form:form>
</html>