<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script>
            //页面加载,绑定单击事件
            $(function () {
                $("#btn").click(function () {
                    $.ajax({
                        url:"user/testResponseBody",
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
<a href="user/testReturnString">testReturnString</a><br/>
<a href="user/testVoid">testVoid</a><br/>
<a href="user/testModelAndView">testModelAndView</a><br/>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br/>
<input type="button" id="btn" value="发送ajax请求"/><br/>
<a href="fileupload.jsp">fileupload.jsp</a><br/>
<h3>异常处理</h3>
<a href="user/testException">异常处理</a>
<h3>拦截器</h3>
<a href="user/testInterceptor">拦截器</a>
</body>
</html>