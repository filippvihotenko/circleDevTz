package by.viho.circledevtz.service;

import by.viho.circledevtz.domain.Product;
import by.viho.circledevtz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
 public class ProductServiceImpl implements ProductService
{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
            return this.productRepository.findAll();
    }
    @Override
    public void update(UUID id,Product productFrom){
        productFrom.setProduct_id(id);
        this.productRepository.findById(id)
                .ifPresentOrElse(product -> {
                    productRepository.save(productFrom);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    public Product create(Product product){
        return this.productRepository.save(product);
    }

    @Override
    public Product getById(UUID id){
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(UUID id){
        Product product =  productRepository.findById(id).orElseThrow(NullPointerException::new);
        productRepository.delete(product);
    }

}
