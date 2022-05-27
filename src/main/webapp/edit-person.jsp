<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ page import="model.Person"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<br>
	<br>
	<html:form action="/excute-edit-person.html" method="post">
		<%Person person = (Person) request.getAttribute("person"); %>
		<br>
		<label>Name</label>
		<html:text property="name" name="person" value="<%=person.getName()%>"></html:text>
		<br>
		<label>Age</label>
		<html:text property="age" name="person" value="<%=person.getAge()%>"></html:text>
		<br>
		<label>Address</label>
		<html:text property="address" name="person" value="<%=person.getAddress()%>"></html:text>
		<br>
		<label>Email</label>
		<html:text property="email" name="person" value="<%=person.getEmail()%>"></html:text>
		<br>
		<html:submit>Edit</html:submit>
	</html:form>
</body>
</html>