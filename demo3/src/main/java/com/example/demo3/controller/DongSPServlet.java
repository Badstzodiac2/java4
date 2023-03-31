package com.example.demo3.controller;

import com.example.demo3.domainmodels.DongSP;
import com.example.demo3.repository.DongSPRepositories;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({"/DongSP/index",
        "/DongSP/create",
        "/DongSP/store",
        "/DongSP/edit",
        "/DongSP/update",
        "/DongSP/delete",})
public class DongSPServlet extends HttpServlet {
    public DongSPRepositories repo = new DongSPRepositories();

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", repo.findAll());
        request.setAttribute("view", "/view/DongSP/index.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String servletPath = request.getRequestURI();
        if (servletPath.contains("/DongSP/create")) {
            this.create(request, response);
        } else if (servletPath.contains("/DongSP/index")) {
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
        request.getRequestDispatcher("/view/DongSP/create.jsp").forward(request, response);

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DongSP dsp = new DongSP();
        try {
            BeanUtils.populate(dsp, request.getParameterMap());
            System.out.println(dsp.toString());
            this.repo.insert(dsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thêm thành công");
        response.sendRedirect("/DongSP/index");


    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        DongSP cv = this.repo.findByMa(ma);
        if (cv == null) {
            System.out.println("Khong tim thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.repo.delete(cv);
            response.sendRedirect("/DongSP/index");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        DongSP dsp = this.repo.findByMa(ma);
        request.setAttribute("dsp", dsp);
        request.getRequestDispatcher("/view/DongSP/edit.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        DongSP cv = this.repo.findByMa(ma);
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.repo.edit(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DongSP/index");
    }

    public void destroy() {
    }
}
