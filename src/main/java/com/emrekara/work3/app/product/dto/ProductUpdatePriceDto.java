package com.emrekara.work3.app.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdatePriceDto {

    private Long id;
    private BigDecimal price;
}
