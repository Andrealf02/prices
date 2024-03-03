package org.main.infraestructure;

import jakarta.transaction.Transactional;
import org.main.application.PriceDTO;
import org.main.application.PriceRepository;
import org.main.domain.ConsultPricesUseCase;
import org.main.domain.Price;
import org.main.infraestructure.exceptions.ConsultPricesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    @Transactional
    @Override
    public List<PriceDTO> consultPrices(LocalDateTime date, Long productId, Long brandId) {
        try {
            List<Price> prices = priceRepository
                    .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                            brandId, productId, date, date);

            return Price.toDTOList(prices);
        } catch (DataAccessException e) {
            throw new ConsultPricesException("Error while querying prices.", e);
        } catch (Exception e) {
            throw new ConsultPricesException("Unexpected error while querying prices.", e);
        }
    }
}
