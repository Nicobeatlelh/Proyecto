<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Es el administrador</h1>
Desde el Modelo<c:out value="${mensajeEnviado}"></c:out><br/>
Variables desde el ambito de la session: <c:out value="${sessionScope.resultado}"/>
<!-- commadName = hace referencia a nuestra clase POJO que uso -->
<sf:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
	<table>
	<tr>
			<td>Un campo fuera del objeto</td>
			<td><input name="fuera" type="text"/> </td>
		</tr>
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
<c:out value="${ resultado }"/>
</body>
</html>