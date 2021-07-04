package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.model.Shop_;
import com.peregud.shoppingcenter.dto.ShopDto;
import com.sun.istack.NotNull;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CriteriaSearchUtil {

    public List<ShopDto> minimumDiscount(int minimumDiscount) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shop> criteriaQuery = criteriaBuilder.createQuery(Shop.class);
        Root<Shop> root = criteriaQuery.from(Shop.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.gt(root.get(Shop_.discount), minimumDiscount));
        return getShopList(entityManager, criteriaQuery);
    }

    public List<ShopDto> shopKeywords(String search) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shop> criteriaQuery = criteriaBuilder.createQuery(Shop.class);
        Root<Shop> root = criteriaQuery.from(Shop.class);
        Predicate predicate1 = criteriaBuilder
                .like(criteriaBuilder.lower(root.get(Shop_.name)), "%" + search.toLowerCase() + "%");
        Predicate predicate2 = criteriaBuilder
                .like(criteriaBuilder.lower(root.get(Shop_.description)), "%" + search.toLowerCase() + "%");
        criteriaQuery.select(root)
                .where(criteriaBuilder.or(predicate1, predicate2));
        return getShopList(entityManager, criteriaQuery);
    }

    @NotNull
    private static List<ShopDto> getShopList(EntityManager entityManager, CriteriaQuery<Shop> criteriaQuery) {
        TypedQuery<Shop> query = entityManager.createQuery(criteriaQuery);
        List<Shop> resultList = query.getResultList();
        List<ShopDto> shopDtoList = new ArrayList<>();
        resultList.forEach(shop -> {
            ShopDto shopDto = new ShopDto();
            shopDto.setName(shop.getName());
            shopDto.setDiscount(shop.getDiscount());
            shopDto.setLocation(shop.getLocation());
            shopDtoList.add(shopDto);
        });
        entityManager.close();
        return shopDtoList;
    }
}
