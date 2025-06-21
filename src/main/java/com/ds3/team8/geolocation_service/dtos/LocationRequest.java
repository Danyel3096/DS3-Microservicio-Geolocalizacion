package com.ds3.team8.geolocation_service.dtos;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationRequest {

    @NotNull(message = "La latitud no puede ser nula")
    @DecimalMin(value = "-90.0", message = "La latitud debe ser mayor o igual a -90.0")
    @DecimalMax(value = "90.0", message = "La latitud debe ser menor o igual a 90.0")
    private BigDecimal latitud;

    @NotNull(message = "La longitud no puede ser nula")
    @DecimalMin(value = "-180.0", message = "La longitud debe ser mayor o igual a -180.0")
    @DecimalMax(value = "180.0", message = "La longitud debe ser menor o igual a 180.0")
    private BigDecimal longitud;

    @NotNull(message = "El timestamp es obligatorio")
    private LocalDateTime timestamp;

    @NotNull(message = "El id del pedido es obligatorio")
    private Long idPedido;
}
