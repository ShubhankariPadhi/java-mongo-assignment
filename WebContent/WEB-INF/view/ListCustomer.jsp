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

<h1> list customer</h1>

<form action="<c:url value="customerSearch" />">
<input type=text name="freeText"  value="${param.freeText}" placeholder="Enter text to search">
<button>Search</button>
</form>

<br/>
<p align="right">
<button onclick="window.location.href='addCustomer'" return false;>AddCustomer</button>
</p>

<table border=1>
 <tr>
 <th>FirstName: </th>
 <th>LastName: </th>
 <th>EmailId: </th>
 <th>Edit</th>
 </tr>
 
<c:forEach items="${theCustomers}" var ="customer">

<c:url var="UpdateLink" value="showUpdateForm">
<c:param  name="customerId" value="${customer.id }" />
</c:url>

<c:url var="DeleteLink" value="deleteRecord">
<c:param  name="customerId" value="${customer.id }" />
</c:url>

<tr>
<td>${customer.first_name}</td>
<td>${customer.last_name}</td>
<td>${customer.email}</td>

<td>
<a href="${UpdateLink}"> Update</a> |
<a  onclick="if(!confirm('Are you sure that want to delete thw customer record ?')) return false; " href="${DeleteLink}" >Delete</a>
</td>
</tr>
</c:forEach>
</table>


</body>
</html>