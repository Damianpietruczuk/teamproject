<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/styleVE.css"%></style>
<html lang="pl-PL">
<body>
<h1>View Employees List</h1>
<table  width="70%" cellspacing="10" cellpadding="10" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    <c:forEach var="employees" items="${list}">
        <tr>
            <td>${employees.id}</td>
            <td>${employees.firstName} ${employees.lastName}</td>
            <td>${employees.salary}</td>

            <td class="btnsInside">
                <form:form method="post" action="delete">
                    <input type="hidden" id="id" name="id" value="${employees.id}"/>
                    <input class="btnsToSeparate" type="submit" class="button" name="Delete" value="delete"/>
                </form:form>
                <form:form method="post" action="edit">
                    <input type="hidden" id="id" name="id" value="${employees.id}"/>
                    <input class="btnsToSeparate" type="submit" class="button" name="Edit" value="edit"/>
                </form:form>
                <form:form method="post" action="fulldata">
                    <input type="hidden" id="id" name="id" value="${employees.id}"/>
                    <input class="btnsToSeparate" type="submit" class="button" name="Fulldata" value="fulldata"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>


    <tr >
        <td colspan="3" width="100%"><a href="/">Main menu</a></td>
        <td colspan="1" width="100%"><form:form method="post" action="test">
            <input type="submit" class="button" name="test" value="test"/>
        </form:form></td>
    </tr>
</table>
</body>
</html>