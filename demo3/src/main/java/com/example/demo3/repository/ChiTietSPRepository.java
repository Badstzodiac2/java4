package com.example.demo3.repository;

import com.example.demo3.domainmodels.ChiTietSP;
import com.example.demo3.utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository  {
    private Session hSession;

    public ChiTietSPRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<ChiTietSP> findAll(){
        String hql = "SELECT cvObj FROM ChiTietSP cvObj";
        TypedQuery<ChiTietSP> query =
                this.hSession.createQuery(hql, ChiTietSP.class);
        return query.getResultList();
    }

    public void insert (ChiTietSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (ChiTietSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (ChiTietSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public ChiTietSP findByUUID (UUID id){
        return this.hSession.find(ChiTietSP.class, id);
    }

    public ChiTietSP findByMa(UUID id){
        String hql = "SELECT cvObj FROM ChiTietSP cvObj WHERE cvObj.Id = ?1";
        TypedQuery<ChiTietSP> query =
                this.hSession.createQuery(hql, ChiTietSP.class);
        query.setParameter(1, id);

        return query.getSingleResult();
    }
}
