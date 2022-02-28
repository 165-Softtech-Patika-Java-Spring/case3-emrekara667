package com.emrekara.work3.app.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String name;
    private BigDecimal price;
    private Long commentId;
}
