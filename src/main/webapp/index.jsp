<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/response.jsp">response.jsp</a>
<hr/>
<h3>文件上传</h3>
<form action="${pageContext.request.contextPath}/user/testFileUpload1" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<hr/>
<form action="${pageContext.request.contextPath}/user/testFileUpload2" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<hr/>
<h3>异常处理</h3>
<a href="${pageContext.request.contextPath}/user/testException">异常处理</a>
<hr/>
<h3>拦截器</h3>
<a href="${pageContext.request.contextPath}/user/testInterceptor">拦截器</a>
</body>
</html>