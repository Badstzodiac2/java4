package com.example.demo3.repository;

import com.example.demo3.domainmodels.ChucVu;
import com.example.demo3.domainmodels.CuaHang;
import com.example.demo3.utils.HibernateUtil;
import com.example.demo3.viewmodel.QLCuaHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {
    private Session hSession;

    public CuaHangRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public List<CuaHang> findAll(){
        String hql = "SELECT chObj FROM CuaHang chObj";
        TypedQuery<CuaHang> query =
                this.hSession.createQuery(hql, CuaHang.class);
        return query.getResultList();
    }
    public void insert (CuaHang ch){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (CuaHang ch){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (CuaHang ch){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public CuaHang findByMa(String ma){
        String hql = "SELECT chObj FROM CuaHang chObj WHERE chObj.Ma = ?1";
        TypedQuery<CuaHang> query =
                this.hSession.createQuery(hql, CuaHang.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }
}
