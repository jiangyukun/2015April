<%--
  User: jiangyukun
  Date: 2015/4/8
  Time: 22:16
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="doLogin" method="post">
    <input name="username">
    <input name="password" type="password">
    <input name="_csrf" type="hidden" value="589afa58-52ee-4f0a-981b-e7cf6bfedffb" />
    <input type="submit" value="提交">
</form>
</body>
<script>


</script>
</html>
