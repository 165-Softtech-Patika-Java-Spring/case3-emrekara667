package com.emrekara.work3.app.product.service.entityservice;

import com.emrekara.work3.app.gen.service.BaseEntityService;
import com.emrekara.work3.app.product.dao.ProductDao;
import com.emrekara.work3.app.product.dto.ProductDto;
import com.emrekara.work3.app.product.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductDao> {

    public ProductEntityService(ProductDao dao) {
        super(dao);
    }


    public Product updateProductPrice(Long id, BigDecimal price) {

        Product product = getByIdWithControl(id);
        product.setPrice(price);
        return save(product);
    }
}
