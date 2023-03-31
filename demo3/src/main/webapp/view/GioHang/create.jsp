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
    <title>Form giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

</head>
<body>
    <div class="container">
        <form method="post" action="store" target="_blank">
            <h1>Form tạo mới giỏ hàng</h1>
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày tạo</label>
                <input type="date" class="form-control" name="ngayTao" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày thanh toán</label>
                <input type="date" class="form-control" name="ngayThanhToan" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên người nhận</label>
                <input type="text" class="form-control" name="tenNguoiNhan" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi" required>
            </div>
            <div class="mb-3">
                <label class="form-label">SĐT</label>
                <input type="number" class="form-control" name="sdt" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tình trạng</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="true" name="tinhTrang" checked required>
                    <label class="form-check-label">
                        Đã thanh toán
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="false" name="tinhTrang" required>
                    <label class="form-check-label">
                        Chưa thanh toán
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" onclick="return validateForm()">Add</button>
        </form>

        <script>
            function validateForm() {
                var ma = document.forms[0]["ma"].value;
                var ngayTao = document.forms[0]["ngayTao"].value;
                var ngayThanhToan = document.forms[0]["ngayThanhToan"].value;
                var tenNguoiNhan = document.forms[0]["tenNguoiNhan"].value;
                var diaChi = document.forms[0]["diaChi"].value;
                var sdt = document.forms[0]["sdt"].value;
                if (ma == null || ma == "" || ngayTao == null || ngayTao == "" || ngayThanhToan == null || ngayThanhToan == "" || tenNguoiNhan == null || tenNguoiNhan == "" || diaChi == null || diaChi == "" || sdt == null || sdt == "") {
                    alert("Vui lòng điền đầy đủ thông tin");
                    return false;
                }
            }
        </script>

    </div>
</body>
</html>
