<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/21/2023
  Time: 2:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form method="post" action="/NhanVien/update?ma=${nv.ma}">
        <h1 style="margin: auto; width: 50%;nborder: 3px solid #008000;
  padding: 10px">Form chỉnh sửa nhân viên</h1>
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" value="${nv.ma}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${nv.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Họ</label>
            <input type="text" class="form-control" name="ho" value="${nv.ho}">
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Nam" name="gioiTinh" ${nv.gioiTinh eq 'Nam' ? 'checked' : ''} >
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Nữ" name="gioiTinh" ${nv.gioiTinh eq 'Nữ' ? 'checked' : ''}>
                <label class="form-check-label">
                    Nữ
                </label>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày sinh</label>
            <input type="date" class="form-control" name="ngaySinh" value="${nv.ngaySinh}">
        </div>
        <div class="mb-3">
            <label class="form-label">SĐT</label>
            <input type="number" class="form-control" name="sdt" value="${nv.sdt}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi" value="${nv.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tình trạng</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Đang làm" name="trangThai" ${nv.trangThai eq 'Đang làm' ? 'checked' : ''} >
                <label class="form-check-label">
                    Đang làm
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Nghỉ việc" name="trangThai" ${nv.trangThai eq 'Nghỉ việc' ? 'checked' : ''}>
                <label class="form-check-label">
                    Nghỉ việc
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
