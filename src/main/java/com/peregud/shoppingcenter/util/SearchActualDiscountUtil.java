package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.transformer.ShopDto;
import com.peregud.shoppingcenter.transformer.ListResultTransformer;
import lombok.experimental.UtilityClass;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class SearchActualDiscountUtil {

    public List<?> selectShopsWithActualDiscount() {
        return (List<?>)
                HibernateUtil.createEntityManager()
                        .createQuery(
                                "SELECT name, discount, location FROM Shop WHERE discountEndDate > :localDate")
                        .setParameter("localDate", LocalDate.now())
                        .unwrap(Query.class)
                        .setResultTransformer(
                                (ListResultTransformer)
                                        (tuples, aliases) -> {
                                            ShopDto shopDto = new ShopDto();
                                            shopDto.setName((String) tuples[0]);
                                            shopDto.setDiscount((Integer) tuples[1]);
                                            shopDto.setLocation((String) tuples[2]);
                                            return shopDto;
                                        }
                        )
                        .getResultList();
    }
}
