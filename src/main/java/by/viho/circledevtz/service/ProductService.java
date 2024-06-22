package by.viho.circledevtz.service;

import by.viho.circledevtz.DTO.ProductDTO;
import by.viho.circledevtz.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService
{
    List<Product> findAllProducts();

    void update(UUID uuid,Product product);

    Product create(Product product);

    Product getById(UUID id);

    void deleteProduct(UUID id);
}
