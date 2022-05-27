<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<html:link action="/add-person.html">Add</html:link>
	
	
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>name</th>
			<th>age</th>
			<th>address</th>
			<th>email</th>
		</tr>
		<logic:iterate name="listPerson" id="Person">
			<tr>
				<td><bean:write name="Person" property="name"/></td>
				<td><bean:write name="Person" property="age" format="##"/></td>
				<td><bean:write name="Person" property="address"/></td>
				<td><bean:write name="Person" property="email"/></td>
				<td>
					<html:link action="/edit-person.html" paramName="Person" paramId="idPerson" paramProperty="id">Edit</html:link> | <html:link action="/delete-person.html" paramName="Person" paramId="idPerson" paramProperty="id" >Delete</html:link> 
				</td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>