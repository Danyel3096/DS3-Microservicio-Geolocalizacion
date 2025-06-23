package com.ds3.team8.geolocation_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal latitud;

    @Column(nullable = false)
    private BigDecimal longitud;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "pedido_id", nullable = false)
    private Long idPedido;

    //enlazar con la entidad "Pedido", usar:
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    // private Pedido pedido;
}