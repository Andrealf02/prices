package org.main.infraestructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.main.application.PriceDTO;
import org.main.domain.ConsultPricesUseCase;
import org.main.infraestructure.exceptions.ConsultPricesException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private ConsultPricesUseCase consultPricesUseCase;

    @InjectMocks
    private PriceController priceController;

    @Test
    void testGetPrice_Success() {
        LocalDateTime applicationDate = LocalDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        List<PriceDTO> expectedPrices = Collections.singletonList(new PriceDTO());

        when(consultPricesUseCase.consultPrices(any(LocalDateTime.class), any(Long.class), any(Long.class)))
                .thenReturn(expectedPrices);

        ResponseEntity<PriceDTO> response = priceController.getPrice(applicationDate, productId, brandId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrices.get(0), response.getBody());
    }

    @Test
    void testGetPrice_Error() {
        LocalDateTime applicationDate = LocalDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        when(consultPricesUseCase.consultPrices(any(LocalDateTime.class), any(Long.class), any(Long.class)))
                .thenThrow(new ConsultPricesException("Test error", new Throwable()));

        ResponseEntity<PriceDTO> response = priceController.getPrice(applicationDate, productId, brandId);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
