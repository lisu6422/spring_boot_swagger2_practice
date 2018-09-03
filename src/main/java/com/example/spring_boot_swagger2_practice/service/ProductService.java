package com.example.spring_boot_swagger2_practice.service;

import com.example.spring_boot_swagger2_practice.model.Product;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  public Product add(Long userId) {
    return new Product();
  }

  public List<Product> getAllByUserId(Long userId) {
    return Arrays.asList(new Product());
  }
}
