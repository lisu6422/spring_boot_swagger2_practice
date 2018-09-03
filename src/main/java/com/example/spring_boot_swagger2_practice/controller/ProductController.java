package com.example.spring_boot_swagger2_practice.controller;

import com.example.spring_boot_swagger2_practice.model.Product;
import com.example.spring_boot_swagger2_practice.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductController {

  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @ApiOperation(value = "add a product")
  @PostMapping
  public ResponseEntity<Long> add(@RequestHeader Long userId) {
    Product orderResponse = productService.add(userId);
    String str = String.format("/orders/%s", orderResponse.getId());
    return ResponseEntity.created(URI.create(str)).build();
  }

  @ApiOperation(value = "get a product by id")
  @GetMapping("/{id}")
  public ResponseEntity<List<Product>> getAllByUserId(@PathVariable Long id) {
    List<Product> orders = productService.getAllByUserId(id);
    return ResponseEntity.ok(orders);
  }
}
