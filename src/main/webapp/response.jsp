<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response</title>
    <%--引入jQuery文件--%>
    <script src="js/jquery-1.12.4.min.js"></script>
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
<a href="${pageContext.request.contextPath}/user/testForwardOrRedirect">testForwardOrRedirect</a>
<hr/>
<%--测试testResponseBody--%>
<input type="button" id="btn" value="发送ajax请求"/>
</body>
</html>