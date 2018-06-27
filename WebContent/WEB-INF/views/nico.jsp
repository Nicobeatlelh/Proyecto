<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="resources/css/bootstrap.min.css" />" type="text/css">
<title>Insert title here</title>
</head>
<body>
<p> Estoy en la página Nico</p>
<p> Éste es el parámetro: </p><c:out value="${ nico }" />
<sf:form action="" method="post" commandName="nico" cssClass="form">
<div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <sf:input cssClass="form-control" path="email" id="exampleInputEmail1" />
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <sf:password cssClass="form-control" path="pass" id="exampleInputPassword1" />
  </div>
  <div class="form-check">
    <sf:checkbox cssClass="form-check-input" path="checkout" id="exampleCheck1"/>
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Guardar Cambios</button>
</sf:form>
</body>
</html>