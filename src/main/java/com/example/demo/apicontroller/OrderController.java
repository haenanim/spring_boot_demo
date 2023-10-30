package com.example.demo.apicontroller;

import com.example.demo.model.Product;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductServie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/orders")
public class OrderController {
    private final ProductServie productServie;
    private final OrderService orderService;

    public OrderController(ProductServie productServie,
                           OrderService orderService) {
        this.productServie = productServie;
        this.orderService = orderService;
        //AppConfig appConfig = new AppConfig();
        //orderService = appConfig.orderService();
    }

    @GetMapping("/{productId}")
    public int getProductPrice(@PathVariable int productId){
        Product product = productServie.getProduct(productId);
        int price = orderService.getPrice(product.getPrice());
        return price;
    }
}
