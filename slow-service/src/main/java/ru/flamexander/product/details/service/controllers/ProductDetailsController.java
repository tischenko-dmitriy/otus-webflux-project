package ru.flamexander.product.details.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flamexander.product.details.service.dtos.ProductDetailsDto;

@RestController
@RequestMapping("/api/v1/details")
public class ProductDetailsController {

    @GetMapping("/{id}")
    public ProductDetailsDto getProductDetailsById(@PathVariable Long id,
                                                   ServerHttpResponse serverHttpResponse) throws InterruptedException {
        Thread.sleep(2500 + (int)(Math.random() * 2500));
        if (id > 100) {
            throw new RuntimeException();
        }

        if (id % 3 == 0) {
            serverHttpResponse.setStatusCode(HttpStatus.NOT_FOUND);
            return new ProductDetailsDto(id, null);
        }

        return new ProductDetailsDto(id, "Product description..");
    }

}
