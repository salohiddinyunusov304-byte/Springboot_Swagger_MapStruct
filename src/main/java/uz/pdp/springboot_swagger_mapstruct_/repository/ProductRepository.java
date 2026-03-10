package uz.pdp.springboot_swagger_mapstruct_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot_swagger_mapstruct_.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);
}
