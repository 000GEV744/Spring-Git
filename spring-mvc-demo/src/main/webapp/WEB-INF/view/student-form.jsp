<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName"/>
		<br><br>
		Last Name: <form:input path="lastName"/>
		
		<br><br>
		
		Country: 
		<%-- <form:select path="country">
			<form:option value="Brazil" label="Brazil"/>
			<form:option value="France" label="France"/>
			<form:option value="Germany" label="Germany"/>
			<form:option value="India" label="India"/>
		</form:select> --%>
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		
		<br><br>
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br><br>
		
		Operating Systems: 
		
	    Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		MAC OS <form:checkbox path="operatingSystems" value="MAC OS"/>
		
		<br><br>
		
		<input type="submit" value="submit"/>
	</form:form>

</body>
</html>