package com.example.product.api;

import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductApi {

    private final ProductRepository productRepository;

    @GetMapping("product")
    public ResponseEntity<String> getProductDetails(@RequestParam("upc") Long upc){
        log.info("Inside getProductDetails");
        Optional<String> podName = Optional.ofNullable(System.getenv("HOSTNAME"));
        return ResponseEntity.ok("Product Details for product "+ upc +" is "
            + productRepository.findByUpc(upc).getDetails()+" from pod "
            + podName.orElse("nothing"));
    }
}
