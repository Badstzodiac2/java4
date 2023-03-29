<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/15/2023
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <title>Edit khach hang</title>
</head>
<body>
<div class="container">
    <script>
        console.log(${kh.ma}+"ma");
    </script>
    <form method="post" action="/KhachHang/update?Ma=${kh.ma}" target="_blank">
        <h1 style="margin: auto; width: 50%;nborder: 3px solid #008000;
  padding: 10px">Form chỉnh sửa khách hàng</h1>
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma" value="${kh.ma}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${kh.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên đệm</label>
            <input type="text" class="form-control" name="tenDem" value="${kh.tenDem}">
        </div>
        <div class="mb-3">
            <label class="form-label">Họ</label>
            <input type="text" class="form-control" name="ho" value="${kh.ho}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày sinh</label>
            <input type="date" class="form-control" name="ngaySinh" value="${kh.ngaySinh}">
        </div>
        <div class="mb-3">
            <label class="form-label">SĐT</label>
            <input type="number" class="form-control" name="sdt" value="${kh.sdt}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi" value="${kh.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Thành phố</label>
            <select class="form-select form-select-sm" name="thanhPho" aria-label=".form-select-sm example">
                <option value="Hà Nội" ${kh.thanhPho =="Hà Nội"} ? "selected" : "">Hà Nội</option>
                <option value="Đà Nẵng" ${kh.thanhPho =="Đà Nẵng"} ?"selected" : "">Đà Nẵng</option>
                <option value="TP HCM" ${kh.thanhPho =="TP HCM"} ?"selected" : "">TP HCM</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Quốc gia</label>
            <select class="form-select form-select-sm" name="quocGia" aria-label=".form-select-sm example">
                <option value="Việt Nam" ${kh.quocGia =="Việt Nam"}>Việt Nam</option>
                <option value="Anh" ${kh.quocGia =="Anh"}>Anh</option>
                <option value="Pháp" ${kh.quocGia =="Pháp"}>Pháp</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Sửa</button>
    </form>
</div>
</body>
</html>
