package com.example.demo3.controller;

import com.example.demo3.repository.CuaHangRepository;
import com.example.demo3.viewmodel.QLChucVu;
import com.example.demo3.viewmodel.QLCuaHang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    public CuaHangServlet(){
        if(repo.findAll().isEmpty()){
            repo.insert(new QLCuaHang("CH001", "Tan Thanh", "Nam Tu Liem", "Ha Noi", "Viet Nam"));
            repo.insert(new QLCuaHang("CH002", "WinMax", "Bac Tu Liem", "Ha Noi", "Viet Nam"));
        }
    }

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

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        QLCuaHang qlCuaHang = new QLCuaHang(ma, ten, diaChi, thanhPho, quocGia);
        if(this.repo.findByMa(ma)!=null){
            repo.edit(qlCuaHang);
        }
        else{
            repo.insert(qlCuaHang);
            System.out.println("Thêm thành công");
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/CuaHang/create.jsp").forward(request,response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang ch = this.repo.findByMa(ma);
        if(ch == null){
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else{
            this.repo.delete(ch);
            response.sendRedirect("/CuaHang/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String ma = request.getParameter("ma");
        QLCuaHang qlCuaHang = this.repo.findByMa(ma);
        request.setAttribute("ch", qlCuaHang);
        request.getRequestDispatcher("/view/CuaHang/edit.jsp").forward(request,response);

    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QLCuaHang qlch = new QLCuaHang();
        try {
            BeanUtils.populate(qlch, request.getParameterMap());
            this.repo.edit(qlch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CuaHang/index");
    }
    public void destroy() {
    }

}
