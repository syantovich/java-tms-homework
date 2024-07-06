package org.syantovich.hometask39thymeleaf.mappers;

import org.mapstruct.Mapper;
import org.syantovich.hometask39thymeleaf.dto.ProductDto;
import org.syantovich.hometask39thymeleaf.entities.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);

    List<ProductDto> toProductDtoList(List<Product> productList);

    List<Product> toProductList(List<ProductDto> productDtoList);
}
