package com.example.demo3.repository;

import com.example.demo3.domainmodels.GioHang;
import com.example.demo3.utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class GioHangRepository {
    private Session hSession;

    public GioHangRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<GioHang> findAll(){
        String hql = "SELECT ghObj FROM GioHang ghObj";
        TypedQuery<GioHang> query =
                this.hSession.createQuery(hql, GioHang.class);
        return query.getResultList();
    }

    public void insert (GioHang cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (GioHang cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (GioHang cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public GioHang findByUUID (UUID id){
        return this.hSession.find(GioHang.class, id);
    }

    public GioHang findByMa(String ma){
        String hql = "SELECT cvObj FROM GioHang cvObj WHERE cvObj.Ma = ?1";
        TypedQuery<GioHang> query =
                this.hSession.createQuery(hql, GioHang.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }
}
