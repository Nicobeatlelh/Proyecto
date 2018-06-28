<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="resources/css/bootstrap.min.css" />" type="text/css">
</head>
<body>
<h1>Es el administrador</h1>
Desde el Modelo<c:out value="${mensajeEnviado}"></c:out><br/>
Variables desde el ambito de la session: <c:out value="${sessionScope.resultado}"/>
<!-- commadName = hace referencia a nuestra clase POJO que uso -->
<sf:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
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
	<table class="table">
	<thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Cargo</th>
      <th scope="col">Fecha Creación</th>
      <th></th>
    </tr>
  </thead>
   <tbody>
	<c:forEach items="${ admins }" var="item">
	 <tr>
      <th scope="row"><c:out value="${ item.idAd }"/></th>
      <td><c:out value="${ item.nombre }"/></td>
      <td><c:out value="${ item.cargo }"/></td>
      <td><c:out value="${ item.fechaCreacion }"/></td>
      <td><a href='<c:url value="/admin/${ item.idAd }/actualizar"/>'>Actualizar</a></td>
    </tr>
    
</c:forEach>
  </tbody>
</table>
</sf:form>
<c:out value="${ resultado }"/>
</body>
</html>