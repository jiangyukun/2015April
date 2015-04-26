<%--
  User: jyk
  Date: 2015/4/1
  Time: 18:34
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/css/bootstrap.css"/>
    <script src="${ctx}/res/js/jquery-2.1.1.js"></script>
</head>
<body>

<button id="toNext" class="btn btn-primary">
    list
</button>
<script>
    var $toNext = $('#toNext');
    $toNext.on('click', function () {
//        window.history.pushState({}, '', '#detail');
        window.location.href = 'detail';
    });
</script>
<script src="${ctx}/resource/js/bootstrap.js"></script>
</body>
</html>
