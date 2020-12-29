<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/anno/testRequestParam?name=小明">RequestParam</a>
<hr/>
<form action="${pageContext.request.contextPath}/anno/testRequestBody" method="post">
    用户姓名:<input type="text" name="uname"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>
<a href="${pageContext.request.contextPath}/anno/testPathVariable/10">PathVariable</a>
<hr/>
<%--指定不同的请求方法,method属性指定为post,提供_method请求参数,该参数取值为我们需要的请求方式--%>
<form action="${pageContext.request.contextPath}/anno/testPathVariable/15" method="post">
    <input type="text" name="uname"/>
    <input type="text" name="age"/>
    <%--提交方式指定为删除--%>
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="提交"/>
</form>
<hr/>
<a href="${pageContext.request.contextPath}/anno/testRequestHeader">RequestHeader</a>
<hr/>
<a href="${pageContext.request.contextPath}/anno/testCookieValue">CookieValue</a>
<hr/>
<form action="${pageContext.request.contextPath}/anno/testModelAttribute" method="post">
    用户姓名:<input type="text" name="uname"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>
<a href="anno/testSessionAttribute">SessionAttribute</a><br/>
<a href="anno/getSessionAttribute">getSessionAttribute</a><br/>
<a href="anno/deleteSessionAttribute">deleteSessionAttribute</a>
</body>
</html>