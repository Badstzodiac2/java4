<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/17/2023
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa cửa hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
                                           integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <form method="post" action="/CuaHang/update?Ma=${ch.ma}" target="_blank">
        <h1 style="margin: auto; width: 50%;nborder: 3px solid #008000;
  padding: 10px">Form chỉnh sửa cửa hàng</h1>
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name = "ma" value="${ch.ma}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${ch.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi" value="${ch.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Thành phố</label>
            <select class="form-select form-select-sm" name="thanhPho" aria-label=".form-select-sm example">
                <option value="Hà Nội" ${ch.thanhPho =="Hà Nội"} ? "selected" : "">Hà Nội</option>
                <option value="Đà Nẵng" ${ch.thanhPho =="Đà Nẵng"} ? "selected" : "">Đà Nẵng</option>
                <option value="TP HCM" ${ch.thanhPho =="TP HCM"} ? "selected" : "">TP HCM</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Quốc gia</label>
            <select class="form-select form-select-sm" name="quocGia" aria-label=".form-select-sm example">
                <option value="Việt Nam" ${ch.quocGia =="Việt Nam"} ? "selected" : "">Việt Nam</option>
                <option value="Anh" ${ch.quocGia =="Anh"} ? "selected" : "">Anh</option>
                <option value="Pháp" ${ch.quocGia =="Pháp"} ? "selected" : "">Pháp</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Sửa</button>
    </form>
</div>
</body>
</html>
