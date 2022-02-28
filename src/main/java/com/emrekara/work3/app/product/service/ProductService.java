package com.emrekara.work3.app.product.service;

import com.emrekara.work3.app.product.converter.ProductMapper;
import com.emrekara.work3.app.product.dto.ProductDto;
import com.emrekara.work3.app.product.dto.ProductSaveRequestDto;
import com.emrekara.work3.app.product.entity.Product;
import com.emrekara.work3.app.product.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEntityService productEntityService;

    public ProductDto save(ProductSaveRequestDto productSaveRequestDto) {

        Product product = ProductMapper.INSTANCE.convertToProduct(productSaveRequestDto);

        product = productEntityService.save(product);

        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);

        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> productList = productEntityService.findAll();

        List<ProductDto> productDtoList = ProductMapper.INSTANCE.convertToProductDtoList(productList);

        return productDtoList;
    }

    public ProductDto findById(Long id) {
        Product product = productEntityService.getByIdWithControl(id);

        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);

        return productDto;
    }

    public void delete(Long id) {
        Product product = productEntityService.getByIdWithControl(id);

        productEntityService.delete(product);
    }
}
