package com.example.springMentoring.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketMapper {

    @Mappings(@Mapping(target = "name", source = "product.name"))
    BasketDTO toBasketDTO(Basket basket);

    List<BasketDTO> toBasketDTOs(List<Basket> baskets);

    Basket toBasket(BasketDTO basketDTO);
}
