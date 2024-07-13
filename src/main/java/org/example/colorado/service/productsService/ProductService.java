package org.example.colorado.service.productsService;

import org.example.colorado.dto.ProductsDto;
import org.example.colorado.entity.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Products addProduct(ProductsDto productDto);
    Optional<Products> getProductById(Integer id);
    List<Products> getAllProducts();
    Products updateProduct(Integer id, ProductsDto productDto);
    void deleteProduct(Integer id);
}
