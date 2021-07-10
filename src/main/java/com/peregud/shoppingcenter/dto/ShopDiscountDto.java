package com.peregud.shoppingcenter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShopDiscountDto {
    private String name;
    private String location;
    private Integer discount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
}
