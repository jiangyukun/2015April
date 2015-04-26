<%--
  User: jyk
  Date: 2015/4/1
  Time: 18:39
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" href="${ctx}/res/css/bootstrap.css"/>
    <script src="${ctx}/res/js/jquery-2.1.1.js"></script>
</head>
<body>
<button id="toAdd" class="btn btn-primary">
    detail
</button>
<script>
    var $toAdd = $('#toAdd');
    $toAdd.on('click', function () {
        window.history.pushState({}, '', '#add');
        window.location.href = 'add';
    });
    window.onpopstate = function () {
        alert(1);
//        history.go(-10);
    };
</script>
</body>
</html>
