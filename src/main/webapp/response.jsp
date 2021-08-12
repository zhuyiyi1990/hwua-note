<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response.jsp</title>
<%--引入jQuery文件--%>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script>
        //页面加载,绑定单击事件
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/user/testResponseBody",
                    contentType:"application/json;charset=utf-8",
                    type:"post",
                    data:'{"username":"tom","password":"111111","age":14}',
                    dataType:"json",
                    success:function (data) {
                        alert(data);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/testReturnString">testReturnString</a><br>
<a href="${pageContext.request.contextPath}/user/testVoid">testVoid</a><br>
<a href="${pageContext.request.contextPath}/user/testModelAndView">testModelAndView</a>
<hr/>
<form action="${pageContext.request.contextPath}/user/handler1" method="post">
    username: <input type="text" name="username"><br/>
    password: <input type="text" name="password"><br/>
    age: <input type="text" name="age"><br/>
    <input type="submit" value="handler1">
</form>
<hr/>
<form action="${pageContext.request.contextPath}/user/handler2" method="post">
    username: <input type="text" name="username"><br/>
    password: <input type="text" name="password"><br/>
    age: <input type="text" name="age"><br/>
    <input type="submit" value="handler2">
</form>
<hr/>
<form action="${pageContext.request.contextPath}/user/handler3" method="post">
    username: <input type="text" name="username"><br/>
    password: <input type="text" name="password"><br/>
    age: <input type="text" name="age"><br/>
    <input type="submit" value="handler3">
</form>
<hr/>
<a href="${pageContext.request.contextPath}/user/testForwardOrRedirect">testForwardOrRedirect</a>
<hr/>
<%--测试testResponseBody--%>
<input type="button" id="btn" value="发送ajax请求"/>
</body>
</html>