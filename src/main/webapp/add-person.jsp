<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<html:link action="/list-person.html">back</html:link>

	<html:form action="/excute-add-person.html" method="post">
		<label>Name</label>
		<html:text property="name" name="person"></html:text>
		<br>
		<label>Age</label>
		<html:text property="age" name="person"></html:text>
		<br>
		<label>Address</label>
		<html:textarea property="address" name="person"></html:textarea>
		<br>
		<label>email</label>
		<html:textarea property="email" name="person"></html:textarea>
		<br>
		<html:submit>Add</html:submit>
	</html:form>
</body>
</html>