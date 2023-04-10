<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 4/7/2023
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
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
<c:if test="${ not empty errorMessage }">
    <div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<div class="container">
    <form method="post" action="store" target="_blank">
        <h1>Form tạo mới chi tiết sp</h1>
        <div class="mb-3">
            <label class="form-label">Sản phẩm</label>
            <select name="sanPham" class="form-select">
                <c:forEach items="${listSanPham}" var="sp">
                    <option value="${sp.ma}">${sp.ten}</option></c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">NSX</label>
            <select name="nhaSanXuat" class="form-select">
                <c:forEach items="${listNXS}" var="nxs">
                    <option value="${nxs.ma}">${nxs.ten}</option></c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Màu sắc</label>
            <select name="mauSac" class="form-select">
                <c:forEach items="${listMauSac}" var="ms">
                    <option value="${ms.ma}">${ms.ten}</option></c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Dòng SP</label>
            <select name="dongSanPham" class="form-select">
                <c:forEach items="${listDongSP}" var="dsp">
                    <option value="${dsp.ma}">${dsp.ten}</option></c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Năm BH</label>
            <input type="number" class="form-control" name="namBH" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <input type="text" class="form-control" name="moTa" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Gía nhập</label>
            <input type="number" class="form-control" name="giaNhap" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Gía bán</label>
            <input type="number" class="form-control" name="giaBan" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng tồn</label>
            <input type="number" class="form-control" name="soLuongTon" required>
        </div>
        <button type="submit" class="btn btn-primary" >Add</button>
    </form>
    </div>
</body>
</html>
