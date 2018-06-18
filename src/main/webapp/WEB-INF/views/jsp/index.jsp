<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form:form method="POST" action="add-customer"
        modelAttribute="customer">
        <table>
            <tr>
                <td><form:label path="customerName">name</form:label></td>
                <td><spring:bind path="customerName">
                <form:input path="customerName" /><form:errors path="customerName"></form:errors>
                </spring:bind></td>
                
            </tr>
            <tr>
                <td><form:label path="phoneNumber">phone</form:label></td>
                <td><form:input path="phoneNumber" /></td>
            </tr>
            <tr>
                <td><form:label path="address">address</form:label></td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td><form:label path="goldmember">goldmember</form:label></td>
                <td><form:input path="goldmember" /></td>
            </tr>
            <tr>
                <td><form:label path="password">password</form:label></td>
                <td>
                <spring:bind path="password">
                <form:password path="password" /><form:errors path="password"></form:errors>
                </spring:bind></td>
            </tr>
            <tr>
                <td><form:label path="buyingNumber">buying number</form:label></td>
                <td><form:input path="buyingNumber" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>