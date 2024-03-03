package org.main.infraestructure;

import org.main.application.PriceDTO;
import org.main.domain.ConsultPricesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    private final ConsultPricesUseCase consultPricesUseCase;
    private PriceDTO priceDTO;

    public PriceController(ConsultPricesUseCase consultPricesUseCase) {
        this.consultPricesUseCase = consultPricesUseCase;
    }

    @GetMapping
    public ResponseEntity<PriceDTO> consultarPrecio(
            @RequestParam("date") LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        return ResponseEntity.ok(priceDTO);
    }
}
