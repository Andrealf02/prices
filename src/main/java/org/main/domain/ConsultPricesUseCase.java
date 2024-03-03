package org.main.domain;

import org.main.application.PriceDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultPricesUseCase {
    List<PriceDTO> consultPrices(LocalDateTime date, Long productId, Long brandId);
}
