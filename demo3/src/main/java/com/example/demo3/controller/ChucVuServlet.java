package com.example.demo3.controller;

import com.example.demo3.domainmodels.ChucVu;
import com.example.demo3.domainmodels.MauSac;
import com.example.demo3.repository.ChucVuRepositories;
import com.example.demo3.viewmodel.QLChucVu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({"/ChucVu/index",
        "/ChucVu/create",
        "/ChucVu/store",
        "/ChucVu/edit",
        "/ChucVu/update",
        "/ChucVu/delete",})
public class ChucVuServlet extends HttpServlet {

    public ChucVuRepositories repo = new ChucVuRepositories();

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/ChucVu/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String servletPath = request.getRequestURI();
        if (servletPath.contains("/ChucVu/create")) {
            this.create(request, response);
        } else if (servletPath.contains("/ChucVu/index")) {
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
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }


    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/ChucVu/create.jsp").forward(request, response);

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ChucVu cv = new ChucVu();
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            HttpSession session = request.getSession();
            if (cv.getMa().isEmpty()||cv.getTen().isEmpty()) {
                session.setAttribute("errorMessage", "Vui lòng nhập đủ dữ liệu");
                response.sendRedirect("/ChucVu/create");
            } else {
                session.setAttribute("cv", cv);
                System.out.println("Thêm thành công");
                System.out.println(cv.toString());
                this.repo.insert(cv);
                response.sendRedirect("/ChucVu/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        ChucVu cv = this.repo.findByMa(ma);
        if (cv == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(cv);
            response.sendRedirect("/ChucVu/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        ChucVu cv = this.repo.findByMa(ma);
        request.setAttribute("cv", cv);
        request.getRequestDispatcher("/view/ChucVu/edit.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        ChucVu cv = this.repo.findByMa(ma);
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.repo.edit(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ChucVu/index");
    }

    public void destroy() {
    }

}
