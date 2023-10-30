package com.example.demo.apicontroller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.service.ProductServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServie productServie;

    @Autowired
    public ProductController(ProductServie productServie) {
        this.productServie = productServie;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productServie.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable int productId){
        Product product = productServie.getProduct(productId);
        return product;
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
        String msg = productServie.addProduct(product);
        return msg;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable int productId,
                                @RequestBody ProductDto productDto) {
        String msg = productServie.updateProduct(productId, productDto);
        return msg;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId){
        return productServie.deleteProduct(productId);
    }
}
