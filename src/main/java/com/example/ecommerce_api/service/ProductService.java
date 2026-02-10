package com.example.ecommerce_api.service;


import com.example.ecommerce_api.entity.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    // IN-MEMORY ARRAYLIST (as requested!)
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Initialize with sample data
    public ProductService() {
        products.add(new Product(idCounter.getAndIncrement(), "Laptop", "High-performance laptop", 999.99, "Electronics"));
        products.add(new Product(idCounter.getAndIncrement(), "Book", "Best selling novel", 14.99, "Books"));
        products.add(new Product(idCounter.getAndIncrement(), "Headphones", "Wireless headphones", 89.99, "Electronics"));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Return copy
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add new product (REQUIRED)
    public Product addProduct(Product product) {
        // Validate
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required");
        }
        if (product.getName().length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters");
        }
        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        // Assign ID and add to list
        product.setId(idCounter.getAndIncrement());
        products.add(product);
        return product;
    }

    // EXTRA (not required but good to have)
    public boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }

    // EXTRA: Get count
    public int getProductCount() {
        return products.size();
    }
}