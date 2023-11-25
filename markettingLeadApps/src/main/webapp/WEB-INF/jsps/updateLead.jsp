<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
</head>
<body>
	<h2>Update Lead</h2>
	<form action="updateLead" method="post">
		<pre>
		    <input type="hidden" name="id" value="${lead.id}"/>
	        First Name <input type="text" name="firstname" value="${lead.firstname}" />
	        Last Name <input type="text" name="lastname" value="${lead.lastname}"/>
	        Email <input type="text" name="email" value="${lead.email}"/>
	        Mobile <input type="text" name="mobile" value="${lead.mobile}"/>
 	        <input type="submit" value="update" />
      </pre>
	</form>
	${msg}  
</body>
</html>