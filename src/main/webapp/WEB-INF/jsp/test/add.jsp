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
<button id="toDetail" class="btn btn-primary">
    add
</button>
<script>
    var $toDetail = $('#toDetail');
    $toDetail.on('click', function () {
//        window.history.pushState({}, '', '#detail');
        window.location.href = 'detail';
    });
    window.onpopstate = function () {
        alert(2);
    };
</script>
</body>
</html>
