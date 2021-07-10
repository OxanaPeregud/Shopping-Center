package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ServletShopService extends ServletService<Shop> {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    public Shop save(Shop shop) {
        return super.save(shop);
    }

    public Shop getById(int id) {
        return super.getById(Shop.class, id);
    }

    public List<?> getList() {
        return super.getAll(Shop.class);
    }

    public void delete(int id) {
        super.delete(Shop.class, id);
    }

    public void deleteList(String[] idList) {
        super.deleteList(Shop.class, idList);
    }

    @SuppressWarnings("unchecked")
    public void set(int id) {
        getById(id).setDiscount(servletDiscountService.getSet((List<Integer>) selectIdForSet(id)));
    }

    public List<?> selectIdForSet(int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        Shop shop = getById(id);
        List<?> list = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("SELECT id FROM Discount WHERE shop = :shop")
                    .setParameter("shop", shop)
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return list;
    }
}
