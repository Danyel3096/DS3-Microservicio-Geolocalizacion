package com.ds3.team8.geolocation_service.repositories;

import com.ds3.team8.geolocation_service.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {

    // Buscar ubicaciones por ID del pedido
    List<Location> findByIdPedido(Long idPedido);

    // Buscar ubicaciones de un pedido después de cierto tiempo (útil para actualizaciones recientes)
    List<Location> findByIdPedidoAndTimestampAfter(Long idPedido, LocalDateTime timestamp);

    // Buscar todas las ubicaciones ordenadas por tiempo (puede servir para mostrar el recorrido)
    List<Location> findByIdPedidoOrderByTimestampAsc(Long idPedido);

    // Buscar última ubicación de un pedido (la más reciente)
    // Location findTopByIdPedidoOrderByTimestampDesc();
}
