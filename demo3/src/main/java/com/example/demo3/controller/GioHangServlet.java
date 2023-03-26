package com.example.demo3.controller;

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


    public GioHangServlet(){
        if(repo.findAll().isEmpty()){
            repo.insert(new QLGioHang( "GHJU1", "2020-10-20", "2020-10-20", "Nguyen Van A", "Ha Dong", "0215464585", "Đã thanh toán"));
            repo.insert(new QLGioHang( "GHJU2", "2020-11-20", "2020-11-20", "Nguyen Van B", "Ha Dong", "0215464585", "Đã thanh toán"));
        }
    }
    
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
        if(uri.contains("store"))
            this.store(request, response);
        else if(uri.contains("update"))
            this.update(request, response);
    }



    protected void store(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        String ma = request.getParameter("ma");
        String ngayTao = request.getParameter("ngayTao");
        String ngayThanhToan = request.getParameter("ngayThanhToan");
        String tenNguoiNhan = request.getParameter("tenNguoiNhan");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String tinhTrang = request.getParameter("tinhTrang");
        QLGioHang qlGioHang = new QLGioHang(ma,ngayTao,ngayThanhToan,tenNguoiNhan,diaChi,sdt,tinhTrang);
        if(this.repo.findByMa(ma)!=null){
            repo.edit(qlGioHang);
        }
        else{
            repo.insert(qlGioHang);
            System.out.println("Thêm thành công");
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/GioHang/create.jsp").forward(request,response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLGioHang gh = this.repo.findByMa(ma);
        if(gh == null){
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else{
            this.repo.delete(gh);
            response.sendRedirect("/GioHang/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String ma = request.getParameter("ma");
        QLGioHang qlGioHang = this.repo.findByMa(ma);
        request.setAttribute("gh", qlGioHang);
        request.getRequestDispatcher("/view/GioHang/edit.jsp").forward(request,response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        QLGioHang qlgh = new QLGioHang();
        try{
            BeanUtils.populate(qlgh, request.getParameterMap());
            this.repo.edit(qlgh);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/GioHang/index");
    }


    public void destroy() {
    }
}
