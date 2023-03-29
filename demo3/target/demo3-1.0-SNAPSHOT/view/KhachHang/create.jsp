<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/9/2023
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

</head>
<body>

    <div class="container">
        <form method="post" action="/KhachHang/store" target="_blank">
            <h1>Form tạo mới khách hàng</h1>
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên đệm</label>
                <input type="text" class="form-control" name="tenDem" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày sinh</label>
                <input type="date" class="form-control" name="ngaySinh" required>
            </div>
            <div class="mb-3">
                <label class="form-label">SĐT</label>
                <input type="tel" class="form-control" name="sdt" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Thành phố</label>
                <select class="form-select form-select-sm" name="thanhPho" aria-label=".form-select-sm example" required>
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Đà Nẵng">Đà Nẵng</option>
                    <option value="TP HCM">TP HCM</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Quốc gia</label>
                <select class="form-select form-select-sm" name="quocGia" aria-label=".form-select-sm example" required>
                    <option value="Việt Nam">Việt Nam</option>
                    <option value="Anh">Anh</option>
                    <option value="Pháp">Pháp</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" name="matKhau" required>
            </div>

            <button type="submit" class="btn btn-primary">Add</button>
        </form>
        <script>
            function validateForm() {
                var ma = document.forms["0"]["ma"].value;
                var ten = document.forms["0"]["ten"].value;
                var ho = document.forms["0"]["ho"].value;
                var ngaySinh = document.forms["0"]["ngaySinh"].value;
                var sdt = document.forms["0"]["sdt"].value;
                var diaChi = document.forms["0"]["diaChi"].value;
                var matKhau = document.forms["0"]["matKhau"].value;

                if (ma == null || ma == "" || ten == null || ten == "" || ho == null || ho == "" || ngaySinh == null || ngaySinh == "" || diaChi == null || diaChi == "" || sdt == null || sdt == "" || matKhau == null || matKhau == "") {
                    alert("Vui lòng điền đầy đủ thông tin");
                    return false;
                }
            }
        </script>
    </div>
</body>
</html>
