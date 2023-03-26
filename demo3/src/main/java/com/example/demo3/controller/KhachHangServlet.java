package com.example.demo3.controller;

import java.io.*;
import java.util.ArrayList;

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

    public KhachHangServlet(){
        if(repo.findAll().isEmpty()){
            repo.insert(new QLKhachHang("PH1", "Ng", "Van", "AAA", "2020-10-20", "0123123123", "HN", "123456", "VN", "HN"));
            repo.insert(new QLKhachHang("PH2", "Tran", "Van", "B", "2021-11-12", "0123123423", "ND", "123456", "VN", "HN"));
        }
    }
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

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter(("ho"));
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        String quocGia = request.getParameter("quocGia");
        QLKhachHang qlKhachHang = new QLKhachHang(ma,ten,tenDem,ho,ngaySinh,sdt,diaChi,matKhau,quocGia,thanhPho);
        if(this.repo.findByMa(ma)!=null){
            repo.edit(qlKhachHang);
        }
        else{
            repo.insert(qlKhachHang);
            System.out.println("Thêm thành công");
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/KhachHang/create.jsp").forward(request,response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang kh = this.repo.findByMa(ma);
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
        String ma = request.getParameter("ma");
        QLKhachHang qlKhachHang = this.repo.findByMa(ma);
        request.setAttribute("kh", qlKhachHang);
        request.getRequestDispatcher("/view/KhachHang/edit.jsp").forward(request,response);

    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QLKhachHang qlkh = new QLKhachHang();
        try {
            BeanUtils.populate(qlkh, request.getParameterMap());
            this.repo.edit(qlkh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang/index");

    }

    public void destroy() {
    }
}