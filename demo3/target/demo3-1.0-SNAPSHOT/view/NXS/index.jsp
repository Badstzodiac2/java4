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
    <title>Bảng NXS</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
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
                <a href="/NXS/create" class="btn btn-success">Thêm mới</a>
            </div>
        </div>
        <c:if test="${ f:length(list) == 0 }">
            <h3>Không có dữ liệu</h3>
        </c:if>

        <table class="table">
            <thead style="background: cyan; font-weight: bold">
            <h3 style="text-align: center">Bảng NXS</h3>
            <thead style="background: cyan; font-weight: bold">
            <td>Mã</td>
            <td>Tên</td>
            <td>Thao tác</td>
            </thead>
            <tbody>
            <c:forEach items="${ list }" var="nxs">
                <tr>
                    <td>${ nxs.ma }</td>
                    <td>${ nxs.ten }</td>
                    <td>
                        <a href="/NXS/edit?Ma=${nxs.ma}" target="_blank" class="btn btn-primary">Cập nhật</a>
                        <a href="/NXS/delete?Ma=${nxs.ma}" class="btn btn-danger">Xóa</a>
                    </td>
                    <td>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
