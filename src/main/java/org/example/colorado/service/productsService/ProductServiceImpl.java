package org.example.colorado.service.productsService;

import org.example.colorado.dto.ProductsDto;
import org.example.colorado.entity.Products;
import org.example.colorado.mapper.ProductMapper;
import org.example.colorado.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Value("${app.upload-dir}")
    private String uploadDir;

    @Autowired
    private ProductsRepository productRepository;

    @Override
    public Products addProduct(ProductsDto productDto) {
        String imageUrl = saveImage(productDto.getImage());
        Products product = ProductMapper.toEntity(productDto, imageUrl);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Optional<Products> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products updateProduct(Integer id, ProductsDto productDto) {
        if (productRepository.existsById(id)) {
            String imageUrl = saveImage(productDto.getImage());
            Products product = ProductMapper.toEntity(productDto, imageUrl);
            product.setId(id);
            product.setUpdatedAt(LocalDateTime.now());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    private String saveImage(MultipartFile image) {
        if (image == null || image.isEmpty()) {
            return null;
        }

        try {
            byte[] bytes = image.getBytes();
            Path path = Paths.get(uploadDir + image.getOriginalFilename());
            Files.write(path, bytes);
            return path.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
