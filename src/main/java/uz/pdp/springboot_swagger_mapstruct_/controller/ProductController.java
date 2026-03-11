package uz.pdp.springboot_swagger_mapstruct_.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_swagger_mapstruct_.payload.BaseResponse;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProductCreator;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProductResponse;
import uz.pdp.springboot_swagger_mapstruct_.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(
        name = "Product Api - Product Controller",
        description = "Api for Managing Products"
)
public class ProductController {
    private final ProductService productService;

    @Operation(
            summary = "Create new product",
            description = "This Api use to create new Product"
    )
    @PostMapping("/create")
    public BaseResponse<ProductResponse> create(@RequestBody @Valid ProductCreator creator) {
        ProductResponse response = productService.create(creator);
        return new BaseResponse<>(response);
    }

    @Operation(
            summary = "Show all products"
    )
    @GetMapping("/findAll")
    public BaseResponse<List<ProductResponse>> findAll() {
        List<ProductResponse> responses = productService.findAll();
        return new BaseResponse<>(responses);
    }

    @Operation(
            summary = "Get product by id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product topildi"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product topilmadi"
                    )
            }
    )
    @GetMapping("/findById/{id}")
    public BaseResponse<ProductResponse> findById(@PathVariable Integer id) {
        ProductResponse responses = productService.findById(id);
        return new BaseResponse<>(responses);
    }

    @Hidden // swagger da chiqmaydi bu
    @DeleteMapping("/deleteById/{id}")
    public BaseResponse<String> deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return new BaseResponse<>("Product deleted successfully");
    }

    @Operation(
            summary = "Find products between prices",
            description = "This API use to find product between given prices"
    )
    @GetMapping("/findProductsBetweenPrices")
    public BaseResponse<List<ProductResponse>> findProductsBetweenPrices(
            @Parameter(
                    name = "minPrice",
                    description = "MinPrice - Looking for minimum price of product",
                    example = "100",
                    required = true
            )
            @RequestParam(name = "minPrice") Integer minPrice,

            @Parameter(
                    name = "maxPrice",
                    description = "maxPrice - Looking for maximum price of product",
                    example = "100",
                    required = true
            )
            @RequestParam(name = "maxPrice") Integer maxPrice
    ) {
        List<ProductResponse> responses = productService.findProductsBetweenPrices(minPrice, maxPrice);
        return new BaseResponse<>(responses);

    }
}
