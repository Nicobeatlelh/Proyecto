<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>acercade</title>
</head>
<body>
<h1>acercade.jsp</h1>
<br/>
Desde el Modelo<c:out value="${mensajeEnviado}"></c:out><br/>
Variables desde el ambito de la session: <c:out value="${sessionScope.resultado}"/>
</body>
</html>