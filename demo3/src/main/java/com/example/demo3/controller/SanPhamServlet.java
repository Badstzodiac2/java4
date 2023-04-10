package com.example.demo3.controller;

import com.example.demo3.domainmodels.SanPham;
import com.example.demo3.repository.SanPhamRepositories;
import com.example.demo3.viewmodel.QLSanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({"/SanPham/index",
        "/SanPham/create",
        "/SanPham/store",
        "/SanPham/edit",
        "/SanPham/update",
        "/SanPham/delete",})
public class SanPhamServlet extends HttpServlet {

    private SanPhamRepositories repo = new SanPhamRepositories();


    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/SanPham/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request,response);
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




    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SanPham sp = new SanPham();
        try{
            BeanUtils.populate(sp, request.getParameterMap());
            HttpSession session = request.getSession();
            if (sp.getMa().isEmpty()||sp.getTen().isEmpty()) {
                session.setAttribute("errorMessage", "Vui lòng nhập đủ dữ liệu");
                response.sendRedirect("/SanPham/create");
            } else {
                session.setAttribute("sp", sp);
                System.out.println("Thêm thành công");
                System.out.println(sp.toString());
                this.repo.insert(sp);
                response.sendRedirect("/SanPham/index");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Thêm thành công");
        response.sendRedirect("/SanPham/index");
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/SanPham/create.jsp").forward(request, response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("Ma");
        SanPham sp = repo.findByMa(ma);
        try {
            BeanUtils.populate(sp, request.getParameterMap());
            this.repo.edit(sp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SanPham/index");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        SanPham qlsp = this.repo.findByMa(ma);
        if (qlsp == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(qlsp);
            response.sendRedirect("/SanPham/index");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        SanPham qlSanPham = this.repo.findByMa(ma);
        request.setAttribute("sp", qlSanPham);
        request.getRequestDispatcher("/view/SanPham/edit.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
