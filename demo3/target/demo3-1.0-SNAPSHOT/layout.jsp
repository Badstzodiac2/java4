<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/19/2023
  Time: 1:34 AM
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
        <nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: rgba(127,173,57,255)">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Dashboard</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/home" target="_blank">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/ChucVu/create" target="_blank">Chức vụ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/GioHang/create" target="_blank">Giỏ hàng</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <br>

        <div class="nav flex-column" style="width: 25%; float: left; border: blue 2px">
            <nav class="nav flex-column" style="color: black; font-weight: bold">
                <a class="nav-link active" aria-current="page" style="color: black;" href="/KhachHang/index">Khách hàng</a>
                <a class="nav-link" style="color: black;" href="/SanPham/index">Sản phẩm</a>
                <a class="nav-link" style="color: black;" href="/GioHang/index">Giỏ hàng</a>
                <a class="nav-link" style="color: black;" href="/NhanVien/index">Nhân viên</a>
                <a class="nav-link" style="color: black;" href="/NXS/index">NXS</a>
                <a class="nav-link" style="color: black;" href="/MauSac/index">Màu sắc</a>
                <a class="nav-link" style="color: black;" href="/ChucVu/index">Chức vụ</a>
                <a class="nav-link" style="color: black;" href="/CuaHang/index">Cửa hàng</a></a>
                <a class="nav-link" style="color: black;" href="/KhachHang/index">Khách hàng</a>

            </nav>
        </div>

        <div style="width: 75%; float: right; background-color: white; ">
            <jsp:include page="${ view }" />
        </div>
    </div>

</body>
</html>
