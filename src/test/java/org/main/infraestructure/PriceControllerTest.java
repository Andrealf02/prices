package org.main.infraestructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.main.application.PriceDTO;
import org.main.domain.ConsultPricesUseCase;
import org.main.infraestructure.exceptions.ConsultPricesException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {
    private MockMvc mockMvc;


    @Mock
    private ConsultPricesUseCase consultPricesUseCase;

    @InjectMocks
    private PriceController priceController;

    @Test
    void testConsultPrice_Success() {
        LocalDateTime date = LocalDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        List<PriceDTO> expectedPrices = Collections.singletonList(new PriceDTO());

        when(consultPricesUseCase.consultPrices(any(LocalDateTime.class), any(Long.class), any(Long.class)))
                .thenReturn(expectedPrices);

        ResponseEntity<List<PriceDTO>> response = priceController.consultarPrecio(date, productId, brandId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrices, response.getBody());
    }

    @Test
    void testConsultPrice_Error() {
        LocalDateTime date = LocalDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        when(consultPricesUseCase.consultPrices(any(LocalDateTime.class), any(Long.class), any(Long.class)))
                .thenThrow(new ConsultPricesException("Test error", new Throwable()));


        ResponseEntity<List<PriceDTO>> response = priceController.consultarPrecio(date, productId, brandId);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }
}
