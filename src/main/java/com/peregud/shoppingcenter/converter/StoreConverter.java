package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Store;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

public class StoreConverter implements Converter<Store> {

    @Override
    public Store convert(HttpServletRequest request) {
        Store.StoreBuilder builder = Store.builder();
        Optional.ofNullable(request.getParameter("id"))
                .map(Integer::parseInt)
                .ifPresent(builder::id);
        return builder
                .name(request.getParameter("name"))
                .description(request.getParameter("description"))
                .discount(Integer.parseInt(request.getParameter("discount")))
                .discountStartDate(LocalDate.parse(request.getParameter("discountStartDate")))
                .discountEndDate(LocalDate.parse(request.getParameter("discountEndDate")))
                .location(request.getParameter("location"))
                .mobile(Long.parseLong(request.getParameter("mobile")))
                .email(request.getParameter("email"))
                .build();
    }
}
