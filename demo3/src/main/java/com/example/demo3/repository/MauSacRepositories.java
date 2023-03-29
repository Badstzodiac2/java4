package com.example.demo3.repository;

import com.example.demo3.domainmodels.MauSac;
import com.example.demo3.utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class MauSacRepositories {

    private Session hSession;

    public MauSacRepositories()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<MauSac> findAll(){
        String hql = "SELECT msObj FROM MauSac msObj";
        TypedQuery<MauSac> query =
                this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();
    }
    public void insert (MauSac ms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void edit (MauSac ms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(ms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (MauSac ms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public MauSac findByUUID (UUID id){
        return this.hSession.find(MauSac.class, id);
    }

    public MauSac findByMa(String ma){
        String hql = "SELECT msObj FROM MauSac msObj WHERE msObj.Ma = ?1";
        TypedQuery<MauSac> query =
                this.hSession.createQuery(hql, MauSac.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }

}
