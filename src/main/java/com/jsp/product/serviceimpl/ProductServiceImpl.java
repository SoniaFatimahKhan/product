package com.jsp.product.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.product.Model.Product;
import com.jsp.product.dto.ProductRequest;
import com.jsp.product.exception.ProductNotFoundException;
import com.jsp.product.repository.ProductRepository;
import com.jsp.product.service.ProductService;
import com.jsp.product.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseStructure<String>> addProduct(Product product) {
        productRepository.save(product);

        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setData("Product has been added to the database successfully");
        responseStructure.setMessage("success");

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            ResponseStructure<Product> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Success");
            responseStructure.setData(optionalProduct.get());
            return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
        } else {
            throw new ProductNotFoundException("Product Not Found");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProductName(updatedProduct.getProductName());
            product.setProductcategory(updatedProduct.getProductcategory());
            product.setProductPrice(updatedProduct.getProductPrice());
            productRepository.save(product);
            ResponseStructure<Product> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Success");
            responseStructure.setData(product);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new ProductNotFoundException("Product Not Found");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.deleteById(productId);
            ResponseStructure<Product> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Success");
            responseStructure.setData(product);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new ProductNotFoundException("Product Not Found");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
        List<Product> productList = productRepository.findAll();
        ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.FOUND.value());
        responseStructure.setMessage("Success");
        responseStructure.setData(productList);
        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
    }

    
    @Operation(description = "The endpoint is used to the add a new product to the database", responses= {
    		@ApiResponse(responseCode = "200", description = "Product saved Successfully"),
    		@ApiResponse(responseCode = "400", description = "Invalid inputs")
    })
    @Override
    public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductcategory(productRequest.getProductcategory());
        product.setProductPrice(productRequest.getProductPrice());
        Product savedProduct = productRepository.save(product);
        ResponseStructure<Product> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Product saved successfully");
        responseStructure.setData(savedProduct);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
}
