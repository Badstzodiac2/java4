package com.example.demo3.controller;

import com.example.demo3.domainmodels.NXS;
import com.example.demo3.domainmodels.NhanVien;
import com.example.demo3.domainmodels.NhanVien;
import com.example.demo3.domainmodels.NhanVien;
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
        String ma = request.getParameter("Ma");
        NhanVien nv = this.repo.findByMa(ma);
        request.setAttribute("nv", nv);
        request.getRequestDispatcher("/view/NhanVien/edit.jsp").forward(request, response);
    }


    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        NhanVien nv = new NhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            System.out.println(nv.toString());
            this.repo.insert(nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thêm thành công");
        response.sendRedirect("/NhanVien/index");

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/NhanVien/create.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        NhanVien nv = this.repo.findByMa(ma);
        if (nv == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(nv);
            response.sendRedirect("/NhanVien/index");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        NhanVien nv = repo.findByMa(ma);
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            this.repo.edit(nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/NhanVien/index");

    }

    public void destroy() {
    }
}
