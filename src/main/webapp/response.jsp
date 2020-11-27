<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script>
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                    url:"user/testResponseBody",
                    contentType:"application/json;charset=utf-8",
                    type:"post",
                    data:'{"username":"tom","password":"111111","age":14}',
                    datatype:"json",
                    success:function(data){
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
<a href="${pageContext.request.contextPath}/user/testVoid">testVoid</a><br/>
<a href="${pageContext.request.contextPath}/user/testModelAndView">testModelAndView</a><br/>
<a href="${pageContext.request.contextPath}/user/testForwardOrRedirect">testForwardOrRedirect</a><br/>
<input type="button" id="btn" value="发送ajax请求"/>
</body>
</html>