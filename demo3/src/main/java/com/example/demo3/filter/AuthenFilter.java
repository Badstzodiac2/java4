package com.example.demo3.filter;

import com.example.demo3.domainmodels.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/KhachHang/*",
            "/NhanVien/*",
            "/DongSP/*",
            "/GioHang/*",
            "/NXS/*",
            "/MauSac/*",
            "/SanPham/*",
            "/ChucVu/*",
            "/CuaHang/*",
            "/ChiTietSP/*"})
public class AuthenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            HttpSession session = req.getSession();
            NhanVien nv = (NhanVien) session.getAttribute("nv");
            if (nv == null) {
                session.setAttribute("errorMessage", "Vui lòng đăng nhập");
                res.sendRedirect("/login");
            } else {
                session.setAttribute("errorMessage", "");
                filterChain.doFilter(req, res);
            }
    }
}
