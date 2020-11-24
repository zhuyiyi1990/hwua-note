<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/account/findAccount">查询账户</a><br/>
    <hr/>
    <a href="${pageContext.request.contextPath}/account/saveAccount">保存账户</a><br/>
    <form action="${pageContext.request.contextPath}/account/saveAccount" method="post">
        <input type="submit" value="post提交方式 保存账户"/>
    </form>
    <hr/>
    <a href="${pageContext.request.contextPath}/account/deleteAccount?name=tom">删除账户</a><br/>
</body>
</html>