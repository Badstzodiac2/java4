package com.example.demo3.controller;

import com.example.demo3.domainmodels.*;
import com.example.demo3.domainmodels.NhanVien;
import com.example.demo3.repository.ChucVuRepositories;
import com.example.demo3.repository.CuaHangRepository;
import com.example.demo3.repository.NhanVienRepositories;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({"/NhanVien/index",
        "/NhanVien/create",
        "/NhanVien/store",
        "/NhanVien/edit",
        "/NhanVien/update",
        "/NhanVien/delete",})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepositories repo = new NhanVienRepositories();
    private ChucVuRepositories chucVuRepo = new ChucVuRepositories();
    private CuaHangRepository cuaHangRepo = new CuaHangRepository();

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/NhanVien/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
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

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("Ma");
        NhanVien nv = this.repo.findByMa(ma);
        request.setAttribute("nv", nv);
        List<ChucVu> positions = this.chucVuRepo.findAll();
        List<CuaHang> listCuaHang = this.cuaHangRepo.findAll();
        request.setAttribute("positions", positions);
        request.setAttribute("listCuaHang", listCuaHang);
        request.getRequestDispatcher("/view/NhanVien/edit.jsp").forward(request, response);
    }


    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        NhanVien nv = new NhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            nv.setCv(new ChucVuRepositories().findByMa(request.getParameter("chucVu")));
            nv.setCh(new CuaHangRepository().findByMa(request.getParameter("cuaHang")));
            HttpSession session = request.getSession();
            if (nv.getMa().isEmpty()||nv.getTen().isEmpty()||nv.getMatKhau().isEmpty()||nv.getNgaySinh()==null) {
                session.setAttribute("errorMessage", "Vui lòng nhập đủ dữ liệu");
                response.sendRedirect("/NhanVien/create");
            } else {
                session.setAttribute("nv", nv);
                this.repo.insert(nv);
                System.out.println("Thêm thành công");
                response.sendRedirect("/NhanVien/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> positions = this.chucVuRepo.findAll();
        List<CuaHang> listCuaHang = this.cuaHangRepo.findAll();
        request.setAttribute("positions", positions);
        request.setAttribute("listCuaHang", listCuaHang);
        request.getRequestDispatcher("/view/NhanVien/create.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        NhanVien nv = this.repo.findByMa(ma);
        if (nv == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(nv);
            response.sendRedirect("/NhanVien/index");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        NhanVien nv = repo.findByMa(ma);
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            this.repo.edit(nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/NhanVien/index");

    }

    public void destroy() {
    }
}
