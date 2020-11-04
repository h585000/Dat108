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
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
	
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
			
			<c:forEach items="${brukerliste}" var="b">
			
			<tr bgcolor="${b.mobil eq mobil ? '#8adf57' : '#fff'}">
				<th>${b.kjonn}</th>
				<th align="left">${b.fornavn} ${b.etternavn}</th>
				<th align="left">${b.mobil}</th>
			</tr>
		</tr>
		</c:forEach>
		
	</table>
	<p>
		<a href="Loggut">Ferdig</a>
	</p>
</body>
</html>