package com.programmingtechie.productservice.controller;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  void createProduct(@RequestBody ProductRequest productRequest) {
    productService.createProduct(productRequest);
  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  List<ProductResponse> getAllProduct() {
    return productService.getAllProducts();
  }

  @GetMapping("/get/{id}")
  @ResponseStatus(HttpStatus.OK)
  ProductResponse getProduct(@PathVariable String id) {
    return productService.getProduct(id);
  }

}