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
    <title>Chỉnh sửa giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form method="post" action="/GioHang/update?ma=${gh.ma}" target="_blank">
        <h1 style="margin: auto; width: 50%;nborder: 3px solid #008000;
  padding: 10px">Form chỉnh sửa giỏ hàng</h1>
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" value="${gh.ma}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày tạo</label>
            <input type="date" class="form-control" name="ngayTao" value="${gh.ngayTao}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày thanh toán</label>
            <input type="date" class="form-control" name="ngayThanhToan" value="${gh.ngayThanhToan}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên người nhận</label>
            <input type="text" class="form-control" name="tenNguoiNhan" value="${gh.tenNguoiNhan}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi" value="${gh.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">SĐT</label>
            <input type="number" class="form-control" name="sdt" value="${gh.sdt}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tình trạng</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Đã thanh toán" name="tinhTrang" ${gh.tinhTrang eq 'Đã thanh toán' ? 'checked' : ''} >
                <label class="form-check-label">
                    Đã thanh toán
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Chưa thanh toán" name="tinhTrang" ${gh.tinhTrang eq 'Chưa thanh toán' ? 'checked' : ''}>
                <label class="form-check-label">
                    Chưa thanh toán
                </label>
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
