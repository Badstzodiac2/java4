package com.example.demo3.controller;

import com.example.demo3.domainmodels.MauSac;
import com.example.demo3.repository.MauSacRepositories;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        MauSac ms = new MauSac();
        try {
            BeanUtils.populate(ms, request.getParameterMap());
            System.out.println(ms.toString());
            HttpSession session = request.getSession();
            if (ms.getMa().isEmpty()||ms.getTen().isEmpty()) {
                session.setAttribute("errorMessage", "Vui lòng nhập đủ dữ liệu");
                response.sendRedirect("/MauSac/create");
            } else {
                session.setAttribute("ms", ms);
                System.out.println("Thêm thành công");
                System.out.println(ms.toString());
                this.repo.insert(ms);
                response.sendRedirect("/MauSac/index");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Thêm thành công");
//        response.sendRedirect("/MauSac/index");

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        MauSac ms = this.repo.findByMa(ma);
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
        String ma = request.getParameter("Ma");
        MauSac ms = this.repo.findByMa(ma);
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
        String ma = request.getParameter("Ma");
        MauSac ms = this.repo.findByMa(ma);
        request.setAttribute("ms", ms);
        request.getRequestDispatcher("/view/MauSac/edit.jsp").forward(request,response);
    }
    
    public void destroy() {
    }
}
