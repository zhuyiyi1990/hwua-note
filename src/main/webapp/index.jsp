<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/account/findAll">测试</a>
<hr/>
<h3>测试保存</h3>
<form action="${pageContext.request.contextPath}/account/saveAccount" method="post">
    姓名:<input type="text" name="name"/><br/>
    金额:<input type="text" name="money"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>