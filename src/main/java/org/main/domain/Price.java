package org.main.domain;

import org.main.application.PriceDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Price {

    private Long productId;
    private Long brandId;
    private Long priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
    private String currency;

    public PriceDTO toDTO() {
        PriceDTO dto = new PriceDTO();
        dto.setProductId(this.productId);
        dto.setBrandId(this.brandId);
        dto.setPriceList(this.priceList);
        dto.setStartDate(this.startDate);
        dto.setEndDate(this.endDate);
        dto.setPrice(this.price);
        dto.setCurrency(this.currency);
        return dto;
    }

    public static List<PriceDTO> toDTOList(List<Price> prices) {
        return prices.stream().map(Price::toDTO).collect(Collectors.toList());
    }
}
