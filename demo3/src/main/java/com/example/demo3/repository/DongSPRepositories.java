package com.example.demo3.repository;

import com.example.demo3.domainmodels.DongSP;
import com.example.demo3.utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class DongSPRepositories {
    private Session hSession;

    public DongSPRepositories()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<DongSP> findAll(){
        String hql = "SELECT dspObj FROM DongSP dspObj";
        TypedQuery<DongSP> query =
                this.hSession.createQuery(hql, DongSP.class);
        return query.getResultList();
    }

    public void insert (DongSP dsp){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(dsp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (DongSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (DongSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public DongSP findByUUID (UUID id){
        return this.hSession.find(DongSP.class, id);
    }

    public DongSP findByMa(String ma){
        String hql = "SELECT spObj FROM DongSP spObj WHERE spObj.Ma = ?1";
        TypedQuery<DongSP> query =
                this.hSession.createQuery(hql, DongSP.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }
}
