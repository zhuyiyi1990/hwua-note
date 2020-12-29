<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/anno/testRequestParam?name=小明">RequestParam</a>
<hr/>
<form action="${pageContext.request.contextPath}/anno/testRequestBody" method="post">
    用户姓名:<input type="text" name="uname"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>