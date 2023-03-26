package com.example.demo3.controller;

import com.example.demo3.repository.SanPhamRepositories;
import com.example.demo3.viewmodel.QLSanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    public SanPhamServlet(){
        if (repo.findAll().isEmpty()) {
            repo.insert(new QLSanPham("SP001", "Sách trẻ em"));
            repo.insert(new QLSanPham("SP002", "Đồ chơi"));
        }
    }

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

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLSanPham qlSanPham = new QLSanPham(ma, ten);
        repo.insert(qlSanPham);
        System.out.println("Thêm thành công");

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/SanPham/create.jsp").forward(request, response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        QLSanPham qlsp = new QLSanPham();
        try {
            BeanUtils.populate(qlsp, request.getParameterMap());
            this.repo.edit(qlsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SanPham/index");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham qlsp = this.repo.findByMa(ma);
        if (qlsp == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(qlsp);
            response.sendRedirect("/SanPham/index");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham qlSanPham = this.repo.findByMa(ma);
        request.setAttribute("sp", qlSanPham);
        request.getRequestDispatcher("/view/SanPham/edit.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
