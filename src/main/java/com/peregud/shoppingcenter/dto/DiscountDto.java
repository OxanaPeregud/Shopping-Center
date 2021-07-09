package com.peregud.shoppingcenter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DiscountDto {
    private Integer id;
    private Integer discount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
}
