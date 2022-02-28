package com.emrekara.work3.app.product.converter;

import com.emrekara.work3.app.product.dto.ProductDto;
import com.emrekara.work3.app.product.dto.ProductSaveRequestDto;
import com.emrekara.work3.app.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveRequestDto productSaveRequestDto);

    ProductDto convertToProductDto(Product product);

    List<ProductDto> convertToProductDtoList(List<Product> productList);

}
