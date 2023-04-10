<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 4/3/2023
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${ not empty errorMessage }">
    <div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<form method="post" action="/login">
    <div class="mt-3">
        <label>Mã NV</label>
        <input type="text" name="maNv" class="form-control" />
    </div>
    <div class="mt-3">
        <label>Password</label>
        <input type="password" name="matKhau" class="form-control" />
    </div>

    <div class="mt-3">
        <button class="btn btn-primary">Đăng nhập</button>
    </div>
</form>
</body>
</html>
