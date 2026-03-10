package uz.pdp.springboot_swagger_mapstruct_.service;

import jakarta.validation.Valid;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProductCreator;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(@Valid ProductCreator creator);

    List<ProductResponse> findAll();

    ProductResponse findById(Integer id);

    void deleteById(Integer id);

    List<ProductResponse> findProductsBetweenPrices(Integer minPrice, Integer maxPrice);
}
