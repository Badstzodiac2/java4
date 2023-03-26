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
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

</head>
<body>
    <div class="container">
        <form method="post"  action="/NhanVien/store" target="_blank">
            <h1>Form tạo mới nhân viên</h1>
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="Nam" name="gioiTinh" checked >
                    <label class="form-check-label">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="Nữ" name="gioiTinh">
                    <label class="form-check-label">
                        Nữ
                    </label>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày sinh</label>
                <input type="date" class="form-control" name="ngaySinh" required>
            </div>
            <div class="mb-3">
                <label class="form-label">SĐT</label>
                <input type="number" class="form-control" name="sdt" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="number" class="form-control" name="matKhau" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tình trạng</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="Đang làm" name="tinhTrang" checked >
                    <label class="form-check-label">
                        Đang làm
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="Nghỉ việc" name="tinhTrang">
                    <label class="form-check-label">
                        Nghỉ việc
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" onclick="return validateForm()">Submit</button>
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
