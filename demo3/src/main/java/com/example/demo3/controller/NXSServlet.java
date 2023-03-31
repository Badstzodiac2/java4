package com.example.demo3.controller;

import com.example.demo3.domainmodels.NXS;
import com.example.demo3.repository.NXSRepositories;
import com.example.demo3.viewmodel.QLKhachHang;
import com.example.demo3.viewmodel.QLNXS;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({"/NXS/index",
        "/NXS/create",
        "/NXS/store",
        "/NXS/edit",
        "/NXS/update",
        "/NXS/delete",})
public class NXSServlet extends HttpServlet {

    public NXSRepositories repo = new NXSRepositories();


    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/NXS/index.jsp");
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

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NXS nxs = this.repo.findByMa(ma);
        if (nxs == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(nxs);
            response.sendRedirect("/NXS/index");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        NXS nxs = this.repo.findByMa(ma);
        request.setAttribute("nxs", nxs);
        request.getRequestDispatcher("/view/NXS/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store"))
            this.store(request, response);
        else if (uri.contains("update"))
            this.update(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String ma = request.getParameter("Ma");
        NXS nxs = repo.findByMa(ma);
        try {
            BeanUtils.populate(nxs, request.getParameterMap());
            this.repo.edit(nxs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/NXS/index");
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/NXS/create.jsp").forward(request,response);

    }

    protected void store(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        NXS nxs = new NXS();
        try{
            BeanUtils.populate(nxs, request.getParameterMap());
            repo.insert(nxs);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Thêm thành công");
        response.sendRedirect("/NXS/index");

    }
    public void destroy() {
    }
}
