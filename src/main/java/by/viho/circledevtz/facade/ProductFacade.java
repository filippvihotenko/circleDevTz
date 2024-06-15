package by.viho.circledevtz.facade;

import by.viho.circledevtz.DTO.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductFacade
{
    List<ProductDTO> findAllProducts();

    void update(ProductDTO productDTO, UUID uuid);

    ProductDTO create(ProductDTO productDTO);

    ProductDTO getById(UUID id);

    void deleteProduct(UUID id);
}
