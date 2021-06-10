<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response.jsp</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/testReturnString">testReturnString</a><br/>
<a href="${pageContext.request.contextPath}/user/testVoid">testVoid</a><br/>
<a href="${pageContext.request.contextPath}/user/testModelAndView">testModelAndView</a>
<hr/>
handler1:
<form action="${pageContext.request.contextPath}/user/handler1">
    username: <input type="text" name="username"><br/>
    password: <input type="text" name="password"><br/>
    age: <input type="text" name="age"><br/>
    <input type="submit" value="submit">
</form>
<hr/>
handler2:
<form action="${pageContext.request.contextPath}/user/handler2">
    username: <input type="text" name="username"><br/>
    password: <input type="text" name="password"><br/>
    age: <input type="text" name="age"><br/>
    <input type="submit" value="submit">
</form>
<hr/>
handler3:
<form action="${pageContext.request.contextPath}/user/handler3">
    username: <input type="text" name="username"><br/>
    password: <input type="text" name="password"><br/>
    age: <input type="text" name="age"><br/>
    <input type="submit" value="submit">
</form>
<hr/>
<a href="${pageContext.request.contextPath}/user/testForwardOrRedirect">testForwardOrRedirect</a>
</body>
</html>