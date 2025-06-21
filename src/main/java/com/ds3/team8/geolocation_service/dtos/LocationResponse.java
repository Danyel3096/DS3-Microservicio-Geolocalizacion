package com.ds3.team8.geolocation_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class LocationResponse {
        private Long id;
        private BigDecimal latitud;
        private BigDecimal longitud;
        private LocalDateTime timestamp;
        private Long idPedido;
    }

