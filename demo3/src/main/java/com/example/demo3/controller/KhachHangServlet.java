package com.example.demo3.controller;

import java.io.*;
import java.util.ArrayList;

import com.example.demo3.domainmodels.KhachHang;
import com.example.demo3.repository.KhachHangRepositories;
import com.example.demo3.viewmodel.QLKhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet({"/KhachHang/index",
        "/KhachHang/create",
        "/KhachHang/store",
        "/KhachHang/edit",
        "/KhachHang/update",
        "/KhachHang/delete",})
public class KhachHangServlet extends HttpServlet {

    public KhachHangRepositories repo = new KhachHangRepositories();

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/KhachHang/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String servletPath = request.getRequestURI();
        if(servletPath.contains("create")){
            this.create(request,response);
        }
        else if(servletPath.contains("index")){
            this.index(request,response);
        }
        else if(servletPath.contains("delete")){
            this.delete(request,response);
        }
        else if(servletPath.contains("edit")){
            this.edit(request,response);
        }
        else{
            this.index(request,response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request, response);
        }
        else if(uri.contains("update")){
            this.update(request, response);
        }
    }



    protected void store(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        KhachHang kh = new KhachHang();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            System.out.println(kh.toString());
            this.repo.insert(kh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thêm thành công");
        response.sendRedirect("/KhachHang/index");

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/KhachHang/create.jsp").forward(request,response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        KhachHang kh = repo.findByMa(ma);
        if(kh == null){
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else{
            this.repo.delete(kh);
            response.sendRedirect("/KhachHang/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String ma = request.getParameter("Ma");
        KhachHang kh = this.repo.findByMa(ma);
        request.setAttribute("kh", kh);
        request.getRequestDispatcher("/view/KhachHang/edit.jsp").forward(request,response);

    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        KhachHang kh = this.repo.findByMa(ma);
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.repo.edit(kh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang/index");

    }

    public void destroy() {
    }
}