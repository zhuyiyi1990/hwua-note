<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="anno/testRequestParam?name=小明">RequestParam</a><br/>
<form action="anno/testRequestBody" method="post">
    用户姓名:<input type="text" name="uname"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
</form>
<a href="anno/testPathVariable/10">PathVariable</a>
<%--指定不同的请求方法,method属性指定为post,提供_method请求参数,该参数取值为我们需要的请求方式--%>
<form action="${pageContext.request.contextPath}/anno/testPathVariable2/10" method="post">
    <input type="text" name="uname"/><br/>
    <input type="text" name="age"/><br/>
    <%--提交方式指定为删除--%>
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="提交"/>
</form>
<a href="anno/testRequestHeader">RequestHeader</a><br/>
<a href="anno/testCookieValue">CookieValue</a><br/>
<form action="anno/testModelAttribute" method="post">
    用户姓名:<input type="text" name="uname"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
</form>
<a href="anno/testSessionAttribute">SessionAttribute</a><br/>
<a href="anno/getSessionAttribute">getSessionAttribute</a><br/>
<a href="anno/deleteSessionAttribute">deleteSessionAttribute</a>
</body>
</html>