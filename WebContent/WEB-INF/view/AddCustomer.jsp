<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Provide Customer Information</h1>
<hr/>


<f:form modelAttribute="customer"   action="saveProcess">

<table border=1>
<f:hidden path="id"/>
<tr>
<td>FirstName</td>
<td><f:input path="first_name" /></td>
</tr>

<tr>
<td>LastName</td>
<td><f:input path="last_name" /></td>
</tr>
<tr>
<td>EmailId</td>
<td><f:input path="email" /></td>
</tr>
<tr>
<td></td>
<td><input type=submit value=Save> &nbsp;
<input type="reset" value=Reset>
</td>
</tr>

</table>

</f:form>


<a href="customerList">Click here to go back  to listCustomers</a>

</body>
</html>