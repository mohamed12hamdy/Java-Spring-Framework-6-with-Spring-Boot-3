package com.telusko.SpringECommerce.service;

import com.telusko.SpringECommerce.model.Product;
import com.telusko.SpringECommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService

{
    @Autowired
    private ProductRepo productRepo;

    public List<Product>getAllProducts(){
        return productRepo.findAll();
    }


    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return  productRepo.save(product);
    }
    public Product updateProduct(int id, Product newProduct, MultipartFile imageFile) throws IOException {
        // Retrieve the existing product from the database
        Optional<Product> optionalOldProduct = productRepo.findById(id);

        if (optionalOldProduct.isEmpty()) {

            throw new IllegalArgumentException("Product not found");
        }

        Product productToSave = optionalOldProduct.get();

        // Update only if the values are different
        if (!newProduct.getName().equals(productToSave.getName())) {
            productToSave.setName(newProduct.getName());
        }

        if (newProduct.getPrice() != productToSave.getPrice()) {
            productToSave.setPrice(newProduct.getPrice());
        }

        if (!newProduct.getDescription().equals(productToSave.getDescription())) {
            productToSave.setDescription(newProduct.getDescription());
        }

        if (!newProduct.getBrand().equals(productToSave.getBrand())) {
            productToSave.setBrand(newProduct.getBrand());
        }

        if (!newProduct.getCategory().equals(productToSave.getCategory())) {
            productToSave.setCategory(newProduct.getCategory());
        }

        if (newProduct.getReleaseDate() != null && !newProduct.getReleaseDate().equals(productToSave.getReleaseDate())) {
            productToSave.setReleaseDate(newProduct.getReleaseDate());
        }

        if (newProduct.getStockQuantity() != productToSave.getStockQuantity()) {
            productToSave.setStockQuantity(newProduct.getStockQuantity());
        }
        if(newProduct.isProductAvailable()!= productToSave.isProductAvailable()){
            productToSave.setProductAvailable(productToSave.isProductAvailable());
        }



        // Update image if provided
        if (imageFile != null && !imageFile.isEmpty()) {
            productToSave.setImageName(imageFile.getOriginalFilename());
            productToSave.setImageType(imageFile.getContentType());
            productToSave.setImageData(imageFile.getBytes());
        }

        // Save the updated product to the database
        return productRepo.save(productToSave);
    }


    public void DeleteProductById(int id) {
         productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String Keyword) {
      return  productRepo.searchProducts(Keyword);
    }
}
