<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="param/testParam?username=tom&password=111">请求参数绑定</a><br/>
    <hr/>
    <form action="param/saveAccount" method="post">
        账户名:<input type="text" name="username"/><br/>
        密码:<input type="text" name="password"/><br/>
        金额:<input type="text" name="money"/><br/>
        用户姓名:<input type="text" name="user.uname"/><br/>
        用户年龄:<input type="text" name="user.age"/><br/>
        用户生日:<input type="text" name="user.birthday"/><br/>
        用户姓名:<input type="text" name="list[0].uname"/><br/>
        用户年龄:<input type="text" name="list[0].age"/><br/>
        用户姓名:<input type="text" name="map['one'].uname"/><br/>
        用户年龄:<input type="text" name="map['one'].age"/><br/>
        <input type="submit" value="提交"/>
    </form>
    <hr/>
    <a href="param/testServlet">获取Servlet原生的API</a>
</body>
</html>