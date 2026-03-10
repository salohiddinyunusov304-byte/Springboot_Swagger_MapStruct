package uz.pdp.springboot_swagger_mapstruct_.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_swagger_mapstruct_.entity.Product;
import uz.pdp.springboot_swagger_mapstruct_.exceptions.DataNotFoundException;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProductCreator;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProductResponse;
import uz.pdp.springboot_swagger_mapstruct_.repository.ProductRepository;
import uz.pdp.springboot_swagger_mapstruct_.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductCreator creator) {
        Product product = Product.builder()
                .name(creator.name())
                .price(creator.price())
                .build();

        Product save = productRepository.save(product);
        return new ProductResponse(save.getId(), save.getName(), save.getPrice());
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getPrice()))
                .toList();
    }

    @Override
    public ProductResponse findById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Product with id " + id + " not found"));
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }

    @Override
    public void deleteById(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new DataNotFoundException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id) ;
    }

    @Override
    public List<ProductResponse> findProductsBetweenPrices(Integer minPrice, Integer maxPrice) {
         return productRepository.findByPriceBetween(minPrice, maxPrice).stream()
                 .map(product -> new ProductResponse(
                         product.getId(),
                         product.getName(),
                         product.getPrice()
                 )).toList();
    }
}
