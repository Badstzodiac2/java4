<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 4/7/2023
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form chỉnh sửa ctsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form method="post" action="/ChiTietSP/update?Id=${ctsp.id}" target="_blank">
        <h1>Form chỉnh sửa chi tiết sp</h1>
        <div class="mb-3">
            <label class="form-label">Sản phẩm</label>
            <select name="sp" class="form-select">
                <c:forEach items="${listctsp}" var="ctsp">
                    <option value="${ctsp.ma}">${ctsp.ten}</option></c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">NSX</label>
            <select name="sp" class="form-select">
                <c:forEach items="${listnxs}" var="nxs">
                    <option value="${nxs.ma}">${nxs.ten}</option></c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">NSX</label>
            <select name="sp" class="form-select">
                <c:forEach items="${listMauSac}" var="ms">
                    <option value="${ms.ma}">${ms.ten}</option></c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Dòng SP</label>
            <select name="sp" class="form-select">
                <c:forEach items="${listDongSPs}" var="dsp">
                    <option value="${dsp.ma}">${dsp.ten}</option></c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Năm BH</label>
            <input type="number" class="form-control" value="${ctsp.namBH}" name="namBH" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <input type="text" class="form-control" value="${ctsp.moTa}" name="moTa" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Gía nhập</label>
            <input type="number" class="form-control" value="${ctsp.giaNhap}" name="giaNhap" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Gía bán</label>
            <input type="number" class="form-control" value="${ctsp.giaBan}" name="giaBan" required>
        </div>
        <button type="submit" class="btn btn-primary" >Add</button>
    </form>
</div>
</body>
</html>
