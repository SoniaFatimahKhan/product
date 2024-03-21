package com.jsp.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.product.Model.Product;
import com.jsp.product.dto.ProductRequest;
import com.jsp.product.service.ProductService;
import com.jsp.product.utility.ErrorStructure;
import com.jsp.product.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService ps;
	
	
		
		@PostMapping(value="/addProduct/{product}")
		public ResponseEntity<ResponseStructure<String>> addProduct(@RequestBody Product product) {
			return ps.addProduct(product);	
		}


//		FINDING PRODUCT ID
		@Operation(description = "The endpoint is used to fetch the product based on the ID ", responses = {
				@ApiResponse(responseCode = "200", description="Product Found"),
				@ApiResponse(responseCode = "404",description = "Product not found by given ID",content= {
						@Content(schema=@Schema(implementation = ErrorStructure.class))
				})
		})
		@GetMapping(value="/findByproductId/{productId}")
		public ResponseEntity<ResponseStructure<Product>> findByproductId(@RequestParam int productId) {
			return ps.findByProductId(productId);
		}
		
		
//		UPDATED BY PRODUCT ID
		//	requestParam<=>PathVariable
		@PutMapping(value="/UpdateByproductId/{productId}")
		public ResponseEntity<ResponseStructure<Product>> UpdateByproductId(@PathVariable int productId,@RequestBody Product updatedProduct) {
			return ps.updateByProductId(productId, updatedProduct);
		}

//		DELETING THE PRODUCT BY USING PRODUCT ID
		@DeleteMapping(value="/DeleteByproductId/{productId}")
		public ResponseEntity<ResponseStructure<Product>> DeleteByproductId(@PathVariable int productId) {
			return ps.deleteByProductId(productId);	
		}

//		FINDING ALL THE PRODUCT
		@GetMapping(value="/findAll")
		public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
			return ps.findAll();	
		}
		
//		SAVING THE PRODUCT 
		@PostMapping(value="/saveProducts/{productRequest}")
		public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody ProductRequest productRequest){
			return ps.saveProduct(productRequest);
			
		}
	}

