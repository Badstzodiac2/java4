package com.example.demo3.repository;

import com.example.demo3.domainmodels.ChucVu;

import com.example.demo3.domainmodels.KhachHang;
import com.example.demo3.utils.HibernateUtil;
import com.example.demo3.viewmodel.QLChucVu;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class ChucVuRepositories {
    private Session hSession;

    public ChucVuRepositories()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<ChucVu> findAll(){
        String hql = "SELECT cvObj FROM ChucVu cvObj";
        TypedQuery<ChucVu> query =
                this.hSession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public void insert (ChucVu cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (ChucVu cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (ChucVu cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public ChucVu findByUUID (UUID id){
        return this.hSession.find(ChucVu.class, id);
    }

    public ChucVu findByMa(String ma){
        String hql = "SELECT cvObj FROM ChucVu cvObj WHERE cvObj.Ma = ?1";
        TypedQuery<ChucVu> query =
                this.hSession.createQuery(hql, ChucVu.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }

    public static void main(String[] args) {
        System.out.println(new ChucVuRepositories().findAll());
    }
}
