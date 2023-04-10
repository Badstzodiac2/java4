<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 4/7/2023
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <title>Bảng chi tiết SP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<div class="row">
    <div class="col-6">
        <a href="/ChiTietSP/create" class="btn btn-success">Thêm mới</a>
    </div>
</div>
<c:if test="${ f:length(list) == 0 }">
    <h3>Không có dữ liệu</h3>
</c:if>

<table class="table">
    <thead style="background: cyan; font-weight: bold">
    <h3 style="text-align: center">Bảng chi tiết SP</h3>
    </thead>
    <thead style="background: cyan; font-weight: bold">
    <td>Sản phẩm</td>
    <td>NXS</td>
    <td>Màu sắc</td>
    <td>Dòng SP</td>
    <td>Năm BH</td>
    <td>Mô tả</td>
    <td>Số lượng tồn</td>
    <td>Giá nhập</td>
    <td>Gía bán</td>
    <td>Thao tác</td>
    </thead>
    <tbody>
    <c:forEach items="${ list }" var="ctsp" >
        <tr>
            <td>${ ctsp.sp.ten }</td>
            <td>${ ctsp.nxs.ten }</td>
            <td>${ctsp.ms.ten}</td>
            <td>${ctsp.dsp.ten}</td>
            <td>${ctsp.namBH}</td>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.giaNhap}</td>
            <td>${ctsp.giaBan}</td>
            <td>
                <a href= "/ChucVu/edit?Id=${ctsp.id}"target="_blank" class="btn btn-primary">Cập nhật</a>
                <a href= "/ChucVu/delete?Id=${ctsp.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
