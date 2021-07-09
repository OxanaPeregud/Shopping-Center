package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.dto.DiscountDto;
import com.peregud.shoppingcenter.dto.ShopDto;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Discount_;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.model.Shop_;
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

    public List<ShopDto> shopKeywords(String search) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shop> criteriaQuery = criteriaBuilder.createQuery(Shop.class);
        Root<Shop> root = criteriaQuery.from(Shop.class);
        Predicate predicate1 = criteriaBuilder
                .like(criteriaBuilder.upper(root.get(Shop_.name)), "%" + search.toUpperCase() + "%");
        Predicate predicate2 = criteriaBuilder
                .like(criteriaBuilder.upper(root.get(Shop_.description)), "%" + search.toUpperCase() + "%");
        criteriaQuery.select(root)
                .where(criteriaBuilder.or(predicate1, predicate2));
        TypedQuery<Shop> query = entityManager.createQuery(criteriaQuery);
        List<Shop> resultList = query.getResultList();
        List<ShopDto> shopDtoList = new ArrayList<>();
        resultList.forEach(shop -> {
            ShopDto shopDto = new ShopDto();
            shopDto.setId(shop.getId());
            shopDto.setName(shop.getName());
            shopDto.setDescription(shop.getDescription());
            shopDto.setLocation(shop.getLocation());
            shopDtoList.add(shopDto);
        });
        entityManager.close();
        return shopDtoList;
    }

    public List<DiscountDto> minimumDiscount(int minimumDiscount) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Discount> criteriaQuery = criteriaBuilder.createQuery(Discount.class);
        Root<Discount> root = criteriaQuery.from(Discount.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.gt(root.get(Discount_.discount), minimumDiscount - 1));
        TypedQuery<Discount> query = entityManager.createQuery(criteriaQuery);
        List<Discount> resultList = query.getResultList();
        List<DiscountDto> discountDtoList = new ArrayList<>();
        resultList.forEach(discount -> {
            DiscountDto discountDto = new DiscountDto();
            discountDto.setId(discount.getId());
            discountDto.setDiscount(discount.getDiscount());
            discountDto.setDiscountStartDate(discount.getDiscountStartDate());
            discountDto.setDiscountEndDate(discount.getDiscountEndDate());
            discountDtoList.add(discountDto);
        });
        entityManager.close();
        return discountDtoList;
    }
}
