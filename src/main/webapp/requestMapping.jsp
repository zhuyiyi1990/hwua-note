<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--写法一：--%>
    <a href="${pageContext.request.contextPath}/account/findAccount">查询账户</a>
    <%--写法二：注意前面不要带/--%>
    <%--<a href="account/findAccount">保存账户</a>--%>
    <a href="${pageContext.request.contextPath}/account/saveAccount">保存账号</a><br/>
    <form action="${pageContext.request.contextPath}/account/saveAccount" method="post">
        <input type="submit" value="post方式保存账户"/>
    </form>
    <a href="${pageContext.request.contextPath}/account/deleteAccount?name=tom">删除账户</a><br/>
</body>
</html>