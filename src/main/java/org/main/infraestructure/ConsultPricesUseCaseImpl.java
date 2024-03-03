package org.main.infraestructure;

import org.main.application.PriceDTO;
import org.main.application.PriceRepository;
import org.main.domain.ConsultPricesUseCase;
import org.main.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultPricesUseCaseImpl implements ConsultPricesUseCase {

    private final PriceRepository priceRepository;

    @Autowired
    public ConsultPricesUseCaseImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<PriceDTO> consultPrices(LocalDateTime date, Long productId, Long brandId) {
        List<Price> prices = priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, date, date);

        return Price.toDTOList(prices);
    }
}
