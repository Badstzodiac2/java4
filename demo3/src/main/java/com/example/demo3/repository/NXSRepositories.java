package com.example.demo3.repository;

import com.example.demo3.domainmodels.NXS;
import com.example.demo3.utils.HibernateUtil;
import com.example.demo3.viewmodel.QLNXS;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NXSRepositories {
    private Session hSession;

    public NXSRepositories()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<NXS> findAll(){
        String hql = "SELECT cvObj FROM NXS cvObj";
        TypedQuery<NXS> query =
                this.hSession.createQuery(hql, NXS.class);
        return query.getResultList();
    }

    public void insert (NXS cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (NXS cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (NXS cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public NXS findByUUID (UUID id){
        return this.hSession.find(NXS.class, id);
    }

    public NXS findByMa(String ma){
        String hql = "SELECT cvObj FROM NXS cvObj WHERE cvObj.Ma = ?1";
        TypedQuery<NXS> query =
                this.hSession.createQuery(hql, NXS.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }
}
