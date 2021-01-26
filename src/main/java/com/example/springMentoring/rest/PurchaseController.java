package com.example.springMentoring.rest;

import com.example.springMentoring.model.PurchaseDTO;
import com.example.springMentoring.model.PurchaseMapper;
import com.example.springMentoring.service.PurchaseService;
import com.example.springMentoring.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final ShopService shopService;
    private final PurchaseService purchaseService;
    private final PurchaseMapper purchaseMapper;

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public List<PurchaseDTO> getAllBaskets() {
        return purchaseMapper.toPurchaseDTOs(purchaseService.getAllPurchases());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public PurchaseDTO doPurchase() {
        return purchaseMapper.toPurchaseDTO(shopService.doPurchase());
    }
}
