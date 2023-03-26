package com.example.demo3.controller;

import com.example.demo3.repository.NhanVienRepositories;
import com.example.demo3.viewmodel.QLNhanVien;
import com.example.demo3.viewmodel.QLNhanVien;
import com.example.demo3.viewmodel.QLNhanVien;
import com.example.demo3.viewmodel.QLNhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/NhanVien/index",
        "/NhanVien/create",
        "/NhanVien/store",
        "/NhanVien/edit",
        "/NhanVien/update",
        "/NhanVien/delete",})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepositories repo = new NhanVienRepositories();

    public NhanVienServlet() {
        if (repo.findAll().isEmpty()) {
            repo.insert(new QLNhanVien("PH1", "Ng", "Van", "Nam", "2020-10-20", "Hanoi", "0123123123", "123456", "Đang làm"));
            repo.insert(new QLNhanVien("PH2", "Tran", "Van", "Nữ", "2020-10-20", "Hanoi", "0123123423", "123456", "Đang làm"));
        }
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/NhanVien/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String servletPath = request.getRequestURI();
        if (servletPath.contains("create")) {
            this.create(request, response);
        } else if (servletPath.contains("index")) {
            this.index(request, response);
        } else if (servletPath.contains("edit")) {
            this.edit(request, response);
        } else if (servletPath.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store"))
            this.store(request, response);
        else if (uri.contains("update"))
            this.update(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        QLNhanVien qlNhanVien = this.repo.findByMa(ma);
        request.setAttribute("nv", qlNhanVien);
        request.getRequestDispatcher("/view/NhanVien/edit.jsp").forward(request, response);
    }


    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ho = request.getParameter(("ho"));
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        String tinhTrang = request.getParameter("tinhTrang");
        QLNhanVien qlNhanVien = new QLNhanVien(ma, ten, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, tinhTrang);
        repo.insert(qlNhanVien);
        System.out.println("Thêm thành công");

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/NhanVien/create.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien kh = this.repo.findByMa(ma);
        if (kh == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(kh);
            response.sendRedirect("/NhanVien/index");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QLNhanVien qlkh = new QLNhanVien();
        try {
            BeanUtils.populate(qlkh, request.getParameterMap());
            this.repo.edit(qlkh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/NhanVien/index");

    }

    public void destroy() {
    }
}
