<%@page pageEncoding="utf-8"%>

<!doctype html>
<html>
	<head>
		<title></title>		
	</head>
	<body>
		<!-- EL取值的范围依次是：page/request/session/application -->
		<h1>${msg}</h1>
		<%=session.getAttribute("msg")%>
		<%=request.getAttribute("msg")%>
		<%=application.getAttribute("msg")%>
		
	</body>
</html>