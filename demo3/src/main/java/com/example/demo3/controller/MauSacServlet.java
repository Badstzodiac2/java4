package com.example.demo3.controller;

import com.example.demo3.repository.MauSacRepositories;
import com.example.demo3.viewmodel.QLMauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/MauSac/index",
        "/MauSac/create",
        "/MauSac/store",
        "/MauSac/edit",
        "/MauSac/update",
        "/MauSac/delete",})
public class MauSacServlet extends HttpServlet {

    private MauSacRepositories repo = new MauSacRepositories();

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        if (repo.findAll().isEmpty()) {
            repo.insert(new QLMauSac("MS01", "Đen"));
            repo.insert(new QLMauSac("MS02", "Đỏ"));

        }
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/MauSac/index.jsp");
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
        if(uri.contains("store")){
            this.store(request, response);
        }
        else if(uri.contains("update")){
            this.update(request,response);
        }
    }



    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/MauSac/create.jsp").forward(request, response);

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLMauSac qlMauSac = new QLMauSac(ma, ten);
        if(this.repo.findByMa(ma)!=null){
            repo.edit(qlMauSac);
        }
        else{
            repo.insert(qlMauSac);
            System.out.println("Thêm thành công");
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac ms = this.repo.findByMa(ma);
        if(ms == null){
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else{
            this.repo.delete(ms);
            response.sendRedirect("/MauSac/index");
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QLMauSac ms = new QLMauSac();
        try{
            BeanUtils.populate(ms, request.getParameterMap());
            this.repo.edit(ms);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/MauSac/index");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac qlMauSac = this.repo.findByMa(ma);
        request.setAttribute("ms", qlMauSac);
        request.getRequestDispatcher("/view/MauSac/edit.jsp").forward(request,response);
    }
    
    public void destroy() {
    }
}