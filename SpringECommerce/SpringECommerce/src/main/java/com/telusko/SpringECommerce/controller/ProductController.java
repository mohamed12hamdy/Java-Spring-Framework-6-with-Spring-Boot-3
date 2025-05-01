package com.telusko.SpringECommerce.controller;

import com.telusko.SpringECommerce.model.Product;
import com.telusko.SpringECommerce.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){

        return  new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
        Optional<Product> product = productService.getProductById(productId);

        if (product.isPresent()) {
            byte[] imageData = product.get().getImageData();
            if (imageData != null && imageData.length > 0) {
                return new ResponseEntity<>(imageData, HttpStatus.OK);
            } else {
               /// still fe product,but no such image
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // or HttpStatus.NOT_FOUND
            }
        } else {
            // Product not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product newProduct, @RequestPart(required = false) MultipartFile imageFile) {
        try {
            Product updatedProduct = productService.updateProduct(id, newProduct, imageFile);
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/product/{id}")

    /// here you do not need anyPayloads
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        try {
            Optional<Product> productToBeDeleted = productService.getProductById(id);

            if (productToBeDeleted.isPresent()) {
                productService.DeleteProductById(id);
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/product")
    public ResponseEntity<?>addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){

        try {
            Product savedProduct = productService.addProduct(product,imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            // Return error response
            return new ResponseEntity<>("Failed to save product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>>searchProducts(@RequestParam String Keyword){
        List<Product>products = productService.searchProducts(Keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }



}
