package org.main.domain;

import jakarta.persistence.*;
import org.main.application.PriceDTO;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "price")
public class Price {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "uuid", nullable = false)
    private Long uuid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "price_list")
    private Long priceList;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    // Constructor, getters y setters

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
