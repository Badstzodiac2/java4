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
    <title>Form màu sắc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

</head>
<body>
    <div class="container">
        <form method="post" action="/MauSac/store" target="_blank">
            <h1>Form tạo mới màu sắc</h1>
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" required>
            </div>

            <button type="submit" class="btn btn-primary" onclick="return validateForm()">Add</button>
        </form>
        <script>
            function validateForm() {
                var ten = document.forms[0]["ten"].value;
                var ma = document.forms[0]["ma"].value;
                if (ten == null || ten == "") {
                    alert("Tên không được để trống");
                    return false;
                }
                if(ma == null || ma == ""){
                    alert("Mã không được để trống");
                    return false;
                }
            }
        </script>
    </div>
</body>
</html>
