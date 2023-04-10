package com.example.demo3.controller;

import com.example.demo3.domainmodels.CuaHang;
import com.example.demo3.repository.CuaHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/CuaHang/index",
        "/CuaHang/create",
        "/CuaHang/store",
        "/CuaHang/edit",
        "/CuaHang/update",
        "/CuaHang/delete",})
public class CuaHangServlet extends HttpServlet {

    public CuaHangRepository repo = new CuaHangRepository();
    

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "view/CuaHang/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
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
            this.store(request,response);
        }
        else if(uri.contains("update")){
            this.update(request,response);
        }
    }



    protected void store(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        CuaHang ch = new CuaHang();
        try {
            BeanUtils.populate(ch, request.getParameterMap());
            HttpSession session = request.getSession();
            if (ch.getMa().isEmpty()||ch.getTen().isEmpty()) {
                session.setAttribute("errorMessage", "Vui lòng nhập đủ dữ liệu");
                response.sendRedirect("/CuaHang/create");
            } else {
                session.setAttribute("ch", ch);
                System.out.println("Thêm thành công");
                System.out.println(ch.toString());
                this.repo.insert(ch);
                response.sendRedirect("/CuaHang/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/CuaHang/create.jsp").forward(request,response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        CuaHang ch = this.repo.findByMa(ma);
        if (ch == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(ch);
            response.sendRedirect("/CuaHang/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String ma = request.getParameter("Ma");
        CuaHang ch = this.repo.findByMa(ma);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/view/CuaHang/edit.jsp").forward(request, response);

    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        CuaHang cv = this.repo.findByMa(ma);
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.repo.edit(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CuaHang/index");
    }
    public void destroy() {
    }

}
