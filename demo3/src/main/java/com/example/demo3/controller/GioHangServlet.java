package com.example.demo3.controller;

import com.example.demo3.domainmodels.CuaHang;
import com.example.demo3.domainmodels.GioHang;
import com.example.demo3.repository.GioHangRepository;
import com.example.demo3.viewmodel.QLGioHang;
import com.example.demo3.viewmodel.QLGioHang;
import com.example.demo3.viewmodel.QLCuaHang;
import com.example.demo3.viewmodel.QLGioHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/GioHang/index",
        "/GioHang/create",
        "/GioHang/store",
        "/GioHang/edit",
        "/GioHang/update",
        "/GioHang/delete",})
public class GioHangServlet extends HttpServlet {
    private GioHangRepository repo = new GioHangRepository();


    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "view/GioHang/index.jsp");
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
        } else if (servletPath.contains("delete")) {
            this.delete(request, response);
        } else if (servletPath.contains("edit")) {
            this.edit(request, response);
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


    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        GioHang gh = new GioHang();
        try {
            BeanUtils.populate(gh, request.getParameterMap());
            HttpSession session = request.getSession();
            if (gh.getMa().isEmpty()||gh.getTenNguoiNhan().isEmpty()||gh.getNgayTao()==null||gh.getSdt().isEmpty()) {
                session.setAttribute("errorMessage", "Vui lòng nhập đủ dữ liệu");
                response.sendRedirect("/MauSac/create");
            } else {
                session.setAttribute("gh", gh);
                System.out.println("Thêm thành công");
                System.out.println(gh.toString());
                this.repo.insert(gh);
                response.sendRedirect("/GioHang/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        repo.insert(gh);
//        System.out.println("Thêm thành công");
//        response.sendRedirect("/GioHang/index");

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/GioHang/create.jsp").forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        GioHang gh = this.repo.findByMa(ma);
        if (gh == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(gh);
            response.sendRedirect("/GioHang/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        GioHang gh = this.repo.findByMa(ma);
        request.setAttribute("gh", gh);
        request.getRequestDispatcher("/view/GioHang/edit.jsp").forward(request, response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("Ma");
        GioHang gh = this.repo.findByMa(ma);
        try {
            BeanUtils.populate(gh, request.getParameterMap());
            this.repo.edit(gh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/GioHang/index");
    }


    public void destroy() {
    }
}
