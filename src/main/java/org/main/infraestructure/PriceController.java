package org.main.infraestructure;

import org.main.application.PriceDTO;
import org.main.domain.ConsultPricesUseCase;
import org.main.infraestructure.exceptions.ConsultPricesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    private final ConsultPricesUseCase consultPricesUseCase;

    @Autowired
    public PriceController(ConsultPricesUseCase consultPricesUseCase) {
        this.consultPricesUseCase = consultPricesUseCase;
    }

    @GetMapping
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        try {
            List<PriceDTO> prices = consultPricesUseCase.consultPrices(applicationDate, productId, brandId);
            PriceDTO selectedPrice = prices.stream().findFirst().orElse(null);
            return ResponseEntity.ok(selectedPrice);
        } catch (ConsultPricesException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
