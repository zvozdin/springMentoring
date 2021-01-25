package com.example.springMentoring.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface PurchaseMapper {

    @Mappings(@Mapping(target = "name", source = "user.login"))
    PurchaseDTO toPurchaseDTO(Purchase purchase);

    List<PurchaseDTO> toPurchaseDTOs(List<Purchase> purchases);
}
