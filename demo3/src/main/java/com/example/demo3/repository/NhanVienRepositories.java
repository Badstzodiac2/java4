package com.example.demo3.repository;

import com.example.demo3.domainmodels.NhanVien;
import com.example.demo3.utils.HibernateUtil;
import com.example.demo3.viewmodel.QLNhanVien;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepositories {
    private Session hSession;

    public NhanVienRepositories()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<NhanVien> findAll(){
        String hql = "SELECT nvObj FROM NhanVien nvObj";
        TypedQuery<NhanVien> query =
                this.hSession.createQuery(hql, NhanVien.class);
        return query.getResultList();
    }

    public void insert (NhanVien cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (NhanVien cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (NhanVien cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public NhanVien findByUUID (UUID id){
        return this.hSession.find(NhanVien.class, id);
    }

    public NhanVien findByMa(String ma){
        String hql = "SELECT nvObj FROM NhanVien nvObj WHERE nvObj.Ma = ?1";
        TypedQuery<NhanVien> query =
                this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
