package com.example.demo3.utils;

import com.example.demo3.domainmodels.*;
import com.example.demo3.repository.ChucVuRepositories;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "1234");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(NXS.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(ChiTietSP.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
        Session session = getFACTORY().openSession();
        String hql = "SELECT obj FROM ChucVu obj WHERE obj.Ma = ?1";
        TypedQuery<ChucVu> query = session.createQuery(hql, ChucVu.class);
        query.setParameter(1, "12345");
        ChucVu cv = query.getSingleResult();
        System.out.println("Chuc vu: " + cv.getTen() + cv.getId());

        List<NhanVien> list = cv.getListNv();
        System.out.println("TenNV: " + list.get(0).getTen());

    }
}
