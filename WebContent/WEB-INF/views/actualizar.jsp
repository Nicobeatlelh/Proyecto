<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="resources/css/bootstrap.min.css" />" type="text/css">
</head>
<body>
<sf:form action="${pageContext.request.contextPath}/admin/save" method="get" commandName="admin">
	<table>
<!-- 	<tr> -->
<!-- 			<td>Un campo fuera del objeto</td> -->
<!-- 			<td><input name="fuera" type="text"/> </td> -->
<!-- 		</tr> -->
		<tr>
			<td>Nombre</td>
			<td><sf:input path="nombre"/> </td>
		</tr>
		<tr>
			<td>Cargo</td>
			<td><sf:input path="cargo"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Guardar Cambios"/></td>
		</tr>
	</table>
	</sf:form>
</body>
</html>