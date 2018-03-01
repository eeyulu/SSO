<%@page pageEncoding="utf-8"%>

<!doctype html>
<html>
	<head>
		<meta charset = "utf-8"/>
		<title>登录</title>		
	</head>
	<body>
	${msg}
		<form action="${path}/doLogin" method="post">
			<p>
				账号：
				<input type="text" name="username" value="${userName}" />
			</p>
			<p>
				密码：
				<input type="password" name="pwd" value="${password}"/>
			</p>
			<p>
				<input type="hidden" name="gotoUrl" value="${gotoUrl}">
				<input type="submit" value="登录" />
			</p>
		</form>
	</body>
</html>