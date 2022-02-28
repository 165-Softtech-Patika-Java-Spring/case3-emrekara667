package com.emrekara.work3.app.product.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ProductSaveRequestDto {

    private String name;
    private BigDecimal price;
    private Long commentId;
}
