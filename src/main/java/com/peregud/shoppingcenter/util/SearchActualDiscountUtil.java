package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.dto.ShopDto;
import com.peregud.shoppingcenter.dto.ListResultTransformer;
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
                                "SELECT id, name, discount, location FROM Shop WHERE discountEndDate >= :localDate")
                        .setParameter("localDate", LocalDate.now())
                        .unwrap(Query.class)
                        .setResultTransformer(
                                (ListResultTransformer)
                                        (tuples, aliases) -> {
                                            ShopDto shopDto = new ShopDto();
                                            shopDto.setId((Integer) tuples[0]);
                                            shopDto.setName((String) tuples[1]);
                                            shopDto.setDiscount((Integer) tuples[2]);
                                            shopDto.setLocation((String) tuples[3]);
                                            return shopDto;
                                        }
                        )
                        .getResultList();
    }
}
