<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success.jsp</title>
</head>
<body>
    <h3>成功!</h3>
    <%--从request域中获取user对象信息--%>
    ${user.username}
    <%System.out.println("success.jsp执行了");%>
</body>
</html>