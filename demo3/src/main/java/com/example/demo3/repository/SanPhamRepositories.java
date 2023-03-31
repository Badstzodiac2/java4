package com.example.demo3.repository;

import com.example.demo3.domainmodels.SanPham;
import com.example.demo3.utils.HibernateUtil;
import com.example.demo3.viewmodel.QLSanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class SanPhamRepositories {

    private Session hSession;

    public SanPhamRepositories()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<SanPham> findAll(){
        String hql = "SELECT cvObj FROM SanPham cvObj";
        TypedQuery<SanPham> query =
                this.hSession.createQuery(hql, SanPham.class);
        return query.getResultList();
    }

    public void insert (SanPham cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (SanPham cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (SanPham cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public SanPham findByUUID (UUID id){
        return this.hSession.find(SanPham.class, id);
    }

    public SanPham findByMa(String ma){
        String hql = "SELECT cvObj FROM SanPham cvObj WHERE cvObj.Ma = ?1";
        TypedQuery<SanPham> query =
                this.hSession.createQuery(hql, SanPham.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }
}
