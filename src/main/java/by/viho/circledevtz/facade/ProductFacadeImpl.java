package by.viho.circledevtz.facade;

import by.viho.circledevtz.DTO.ProductDTO;
import by.viho.circledevtz.domain.Product;
import by.viho.circledevtz.mapper.MapperConfig;
import by.viho.circledevtz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductFacadeImpl implements ProductFacade
{

    private ProductService productService;
    private MapperConfig mapperConfig;

    @Autowired
    public ProductFacadeImpl(ProductService productService, MapperConfig mapperConfig)
    {
        this.productService = productService;
        this.mapperConfig = mapperConfig;
    }

   /*public Iterable<ProductDTO> findAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        this.productService.f
   *//*.forEach(product -> {
            ProductDTO productDTO = mapperConfig.convertTo(product, ProductDTO.class);
            productDTOList.add(productDTO);*//*
        });
        return productDTOList;
    }*/

    @Override
    public List<ProductDTO> findAllProducts(){
        return this.productService.findAllProducts()
                .stream().map(product -> mapperConfig.convertTo(product, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void update(ProductDTO productDTO, UUID uuid){
        Product product = mapperConfig.convertTo(productDTO, Product.class);
        this.productService.update(uuid,product);
    }

    @Override
    public ProductDTO create(ProductDTO productDTO){
        Product product = this.productService.create(mapperConfig.convertTo(productDTO, Product.class));
        return mapperConfig.convertTo(product, ProductDTO.class);
    }

    @Override
    public ProductDTO getById(UUID id){
        Product product =  this.productService.getById(id);
        return mapperConfig.convertTo(product, ProductDTO.class);
    }

    @Override
    public void deleteProduct(UUID id){
        this.productService.deleteProduct(id);
    }
}
