<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleEF.css"%></style>
<html lang="pl-PL">
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
            <td><form: input path="Employee_id"></form:></td>
        </tr>

        <tr>
            <td class="lastPrinter" colspan="2" width="100%"><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</html>