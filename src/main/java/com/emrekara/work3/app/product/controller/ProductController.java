package com.emrekara.work3.app.product.controller;

import aj.org.objectweb.asm.Type;
import com.emrekara.work3.app.product.dto.ProductDto;
import com.emrekara.work3.app.product.dto.ProductSaveRequestDto;
import com.emrekara.work3.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity save(@RequestBody ProductSaveRequestDto productSaveRequestDto){

        ProductDto productDto = productService.save(productSaveRequestDto);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<ProductDto> productDtoList = productService.findAll();

        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        ProductDto productDto = productService.findById(id);

        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity updateProductPrice(@PathVariable Long id, @RequestParam BigDecimal price){
        ProductDto productDto = productService.updateProductPrice(id,price);

        return ResponseEntity.ok(productDto);
    }


}
