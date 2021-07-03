package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.model.Shop;
import lombok.experimental.UtilityClass;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class SearchUtil {

    public List<?> shopSearch(String request) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<List<?>> shops = new ArrayList<>();
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                    .buildQueryBuilder()
                    .forEntity(Shop.class)
                    .get();

            FullTextQuery query = fullTextEntityManager.createFullTextQuery(
                    queryBuilder.keyword().wildcard()
                            .onFields("name", "description")
                            .matching(request + "*")
                            .createQuery(),
                    Shop.class
            );
            shops.add(query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return shops;
    }

    public List<?> discountSearch(int minimumDiscount) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<List<?>> shops = new ArrayList<>();
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                    .buildQueryBuilder()
                    .forEntity(Shop.class)
                    .get();
            FullTextQuery query = fullTextEntityManager.createFullTextQuery(
                    queryBuilder.range()
                            .onField("discount")
                            .above(minimumDiscount)
                            .createQuery(),
                    Shop.class
            );
            shops.add(query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return shops;
    }
}
