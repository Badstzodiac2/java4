<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/10/2023
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="container">
        <div class="row">
            <div class="col-6">
                <a href="/NhanVien/create" class="btn btn-success">Thêm mới</a>
            </div>
        </div>
        <c:if test="${ f:length(list) == 0 }">
            <h3>Không có dữ liệu</h3>
        </c:if>
        <table class="table">
            <thead style="background: cyan; font-weight: bold">
                <h3 style="text-align: center">Bảng nhân viên</h3>
            </thead>
            <thead style="background: cyan; font-weight: bold">
            <td>Mã</td>
            <td>Tên</td>
            <td>Họ</td>
            <td>Giới tính</td>
            <td>Ngay sinh</td>
            <td>Dia Chi</td>
            <td>SDT</td>
            <td>Trạng thái</td>
            <td>Thao tác</td>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="nv">
                <tr>
                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.ho}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.trangThai}</td>
                    <td>
                        <a href="/NhanVien/edit?ma=${nv.ma}" target="_blank" class="btn btn-primary">Cập nhật</a>
                        <a href="/NhanVien/delete?ma=${nv.ma}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
