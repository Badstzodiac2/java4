package com.example.demo3.controller;

import com.example.demo3.domainmodels.NhanVien;
import com.example.demo3.repository.NhanVienRepositories;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login"
            ,"/logout"})
public class LoginServlet extends HttpServlet {
    private NhanVienRepositories nvRepo = new NhanVienRepositories();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.endsWith("/logout")) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute("view", "/view/login.jsp");
            request.getRequestDispatcher("/layout.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("maNv");
        String matKhau = req.getParameter("matKhau");
        NhanVien nv = this.nvRepo.login(ma, matKhau);
        HttpSession session = req.getSession();
        if (nv == null) {
            // Báo lỗi
            session.setAttribute("errorMessage", "Sai tài khoản/mật khẩu");
            resp.sendRedirect("/login");
        } else {
            // Đăng nhập thành công
            session.setAttribute("nv", nv);
            resp.sendRedirect("/KhachHang/index");
        }
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
            response.sendRedirect("/login");
        }
    }
}
