package by.viho.circledevtz.controller;

import by.viho.circledevtz.DTO.ProductDTO;
import by.viho.circledevtz.exceptions.NotCreatedProductException;
import by.viho.circledevtz.exceptions.ProductErrorResponce;
import by.viho.circledevtz.facade.ProductFacade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static by.viho.circledevtz.exceptions.CheckingControllerExceptions.checkingErrors;

@RestController
@RequestMapping("/product")
public class ProductController
{
    private ProductFacade productFacade;


    @Autowired
    public ProductController(ProductFacade productFacade)
    {
        this.productFacade = productFacade;
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDTO> getPruductDTObyId(@PathVariable("productId") UUID id){
        return  ResponseEntity.ok(this.productFacade.getById(id));
    }

    @PatchMapping("/update/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("productId") UUID id){

        productFacade.update(productDTO , id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult bindingResult) throws NotCreatedProductException
    {
        checkingErrors(bindingResult);
        return ResponseEntity.ok(productFacade.create(productDTO));
    }

    @GetMapping("all")
    public List<ProductDTO> getAll(){
        return productFacade.findAllProducts();
    }
    @DeleteMapping("delete/{productId}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("productId") UUID id)
    {
        productFacade.deleteProduct(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler()
    public ResponseEntity<ProductErrorResponce> handlerException(NotCreatedProductException e){
        ProductErrorResponce responce = new ProductErrorResponce(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(responce, HttpStatus.BAD_REQUEST);
    }
}
