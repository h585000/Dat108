<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>

	<c:out value="${fornavn}"/>
	&nbsp;&nbsp;&nbsp;<br />
	<c:out value="${etternavn}"/>
	&nbsp;&nbsp;&nbsp;<br />
	<c:out value="${mobil}"/>
	&nbsp;&nbsp;&nbsp;<br />
	<c:out value="${kjonn}"/>
		
		
	</p>
	<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>