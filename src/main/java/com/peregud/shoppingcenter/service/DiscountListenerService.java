package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.DiscountStatistics;
import com.peregud.shoppingcenter.util.HibernateUtil;

import javax.persistence.EntityManager;

public class DiscountListenerService {

    public void save(String discount) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            DiscountStatistics discountStatistics = DiscountStatistics.builder()
                    .discount(discount)
                    .build();
            entityManager.merge(discountStatistics);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
