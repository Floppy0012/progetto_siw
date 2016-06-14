<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <h1>Login</h1>
	 <form action="login.do" method="POST">
		<p>Username: <input type="text" name="username"/></p>
		<p>Password: <input type="password" name="password"/></p>
		<p><input type="reset" value="Reimposta"/></p>
        <p><input type="submit" value="Login" name="login"/></p>
	</form>
  </body>
</html>
