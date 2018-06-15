<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Address</th>
    </tr>
    <c:if test="${not empty listCustomer}">
      <c:forEach var="customer" items="${listCustomer}">
        <tr style="border: 1px black solid">
          <td>${customer.customerId}</td>
          <td>${customer.customerName}</td>
          <td>${customer.address}</td>
          <%-- <td> <a href="${urlView}/${customer.id}">View</a></td>
          <td> <a href="${urlUpdate}/${customer.id}">Edit</a></td>
          <td> <a href="${urlDelete}/${customer.id}">Delete</a></td> --%>
        </tr>
      </c:forEach>
    </c:if>
  </table>
</body>
</html>