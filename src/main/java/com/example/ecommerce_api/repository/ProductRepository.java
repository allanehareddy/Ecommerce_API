package com.example.ecommerce_api.repository;



import com.example.ecommerce_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find by category
    List<Product> findByCategory(String category);

    // Find products with price less than
    List<Product> findByPriceLessThan(Double price);

    // Find products with quantity greater than
    List<Product> findByQuantityGreaterThan(Integer quantity);

    // Search by name containing
    List<Product> findByNameContainingIgnoreCase(String name);
}