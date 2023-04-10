package com.example.demo3.controller;

import com.example.demo3.domainmodels.*;
import com.example.demo3.repository.*;
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

@WebServlet({"/ChiTietSP/index",
        "/ChiTietSP/create",
        "/ChiTietSP/store",
        "/ChiTietSP/edit",
        "/ChiTietSP/update",
        "/ChiTietSP/delete",})
public class ChiTietSPServlet extends HttpServlet {
    public ChiTietSPRepository repo = new ChiTietSPRepository();
    public SanPhamRepositories sanPhamRepo = new SanPhamRepositories();
    public MauSacRepositories mauSacRepo = new MauSacRepositories();
    public DongSPRepositories dongSPRepo = new DongSPRepositories();
    public NXSRepositories nxsRepo = new NXSRepositories();

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/ChiTietSP/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String servletPath = request.getRequestURI();
        if (servletPath.contains("/ChiTietSP/create")) {
            this.create(request, response);
        } else if (servletPath.contains("/ChiTietSP/index")) {
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
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }


    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham>listSanPham = this.sanPhamRepo.findAll();
        List<NXS> listNXS = this.nxsRepo.findAll();
        List<MauSac>listMauSac = this.mauSacRepo.findAll();
        List<DongSP>listDongSP = this.dongSPRepo.findAll();
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listNXS", listNXS);
        request.setAttribute("listMauSac", listMauSac);
        request.setAttribute("listDongSP", listDongSP);

        request.getRequestDispatcher("/view/ChiTietSP/create.jsp").forward(request, response);

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ChiTietSP ctsp = new ChiTietSP();
        System.out.println(request.getParameter("sanPham")+ "metahuman is coming");
        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
            ctsp.setDsp(new DongSPRepositories().findByMa(request.getParameter("dongSanPham")));
            ctsp.setSp(new SanPhamRepositories().findByMa(request.getParameter("sanPham")));
            ctsp.setMs(new MauSacRepositories().findByMa(request.getParameter("mauSac")));
            ctsp.setNxs(new NXSRepositories().findByMa(request.getParameter("nhaSanXuat")));
            HttpSession session = request.getSession();
            if (ctsp.getGiaBan()==null) {
                session.setAttribute("errorMessage", "Vui lòng nhập đủ dữ liệu");
                response.sendRedirect("/ChiTietSP/create");
            } else {
                session.setAttribute("ctsp", ctsp);
                System.out.println("Thêm thành công");
                this.repo.insert(ctsp);
                response.sendRedirect("/ChiTietSP/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Id");
        ChiTietSP ctsp = this.repo.findByMa(UUID.fromString(ma));
        if (ctsp == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(ctsp);
            response.sendRedirect("/ChiTietSP/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Id");
        ChiTietSP ctsp = this.repo.findByMa(UUID.fromString(ma));
        request.setAttribute("ctsp", ctsp);
        request.getRequestDispatcher("/view/ChiTietSP/edit.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Id");
        ChiTietSP ctsp = this.repo.findByMa(UUID.fromString(ma));
        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
            this.repo.edit(ctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ChiTietSP/index");
    }

    public void destroy() {
    }
}
