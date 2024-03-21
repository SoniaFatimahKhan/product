package com.jsp.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.product.Model.Product;
import com.jsp.product.dto.ProductRequest;
import com.jsp.product.utility.ResponseStructure;

public interface ProductService {

    ResponseEntity<ResponseStructure<String>> addProduct(Product product);

    ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);

    ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product product);

    ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);

    ResponseEntity<ResponseStructure<List<Product>>> findAll();

    ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest);
}
