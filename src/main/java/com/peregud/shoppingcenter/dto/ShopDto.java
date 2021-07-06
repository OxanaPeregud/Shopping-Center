package com.peregud.shoppingcenter.dto;

import lombok.Data;

@Data
public class ShopDto {
    private Integer id;
    private String name;
    private Integer discount;
    private String location;
}
