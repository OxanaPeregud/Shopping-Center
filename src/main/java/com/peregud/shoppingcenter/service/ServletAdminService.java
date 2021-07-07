package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Admin;
import com.peregud.shoppingcenter.util.HibernateUtil;

import javax.persistence.EntityManager;

public class ServletAdminService extends ServletService<Admin> {

    public String findAdmin(String name, String password) {
        String result = "false";
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            result = (String) entityManager.createQuery("SELECT 'true' FROM Admin WHERE name = :name and " +
                    "password = :password")
                    .setParameter("name", name)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return result;
    }
}
