<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>

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
                <a class="navbar-brand" href="#">Thêm thuộc tính mới</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
        <ul class="nav flex-column" style="width: 25%; float: left;">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false"
                        style="border-radius: 0%; background-color: rgba(127,173,57,255); width: 300px; font-weight: bold;">
                    <i class="fa-solid fa-bars" style="padding-right: 10px;"></i>Xem danh sách bảng
                </button>
                <ul class="dropdown-menu" style="margin: 0px; width: 300px; border-radius: 0%; margin-left: 10px;"
                    id="w-drop">
                    <li><a class="dropdown-item" href="/KhachHang/index" target="_blank">Khách hàng</a></li>
                    <li><a class="dropdown-item" href="/SanPham/index" target="_blank">Sản phẩm</a></li>
                    <li><a class="dropdown-item" href="/GioHang/index" target="_blank">Giỏ hàng</a></li>
                    <li><a class="dropdown-item" href="/NhanVien/index" target="_blank">Nhân viên</a></li>
                    <li><a class="dropdown-item" href="/NXS/index" target="_blank">NXS</a></li>
                    <li><a class="dropdown-item" href="/MauSac/index" target="_blank">Màu sắc</a></li>
                    <li><a class="dropdown-item" href="/ChucVu/index" target="_blank">Chức vụ</a></li>
                    <li><a class="dropdown-item" href="/CuaHang/index" target="_blank">Cửa hàng</a></li>
                    <li><a class="dropdown-item" href="/DongSP/index" target="_blank">Dòng SP</a></li>
                </ul>
                <script>
                    var Webflow = Webflow || [];
                    Webflow.push(function () {
                        document.getElementById('w-drop').classList.add('w--open');
                    });
                </script>
            </div>
        </ul>
        <div style="width: 75%; float: right; background-color: white; ">
            <h1 style="margin: auto">test: chuc vu, cua hang, gio hang, khach hang, mau sac, san pham</h1>
            <br>
            <h1 style="margin: auto">test2 : chuc vu, cua hang, gio hang, khach</h1>
        </div>
    </div>


</body>
</html>