<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<title>登录</title>		
	</head>
	<body>
		<h1>登录成功，欢迎访问系统</h1>
		<h2>参数userName:${userName}</h2>
		参数pwd:${pwd}<br>
		<p><%=session.getAttribute("user")%></p>
		<p>${user}</p>
		${password}<br>
		<p>OGNL:<s:property value="userName"/>
			OGNL:<s:property value="pwd"/>
		</p>
		
	</body>
</html>