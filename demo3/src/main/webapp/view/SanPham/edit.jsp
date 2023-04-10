<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/21/2023
  Time: 5:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form method="post" action="SanPham/update?Ma=${sp.ma}">
        <h1 style="margin: auto; width: 50%;nborder: 3px solid #008000;
  padding: 10px">Form chỉnh sửa sản phẩm</h1>
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" value="${sp.ma}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name = "ten" value="${sp.ten}">
        </div>
        <button type="submit" class="btn btn-primary">Sửa</button>
    </form>
</body>
</html>
