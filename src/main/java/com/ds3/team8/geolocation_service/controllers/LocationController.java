package com.ds3.team8.geolocation_service.controllers;

import com.ds3.team8.geolocation_service.dtos.LocationRequest;
import com.ds3.team8.geolocation_service.dtos.LocationResponse;
import com.ds3.team8.geolocation_service.services.ILocationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    // Obtener todas las ubicaciones
    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAllLocations() {
        return ResponseEntity.ok(locationService.findAll());
    }

    // Obtener ubicaciones con paginación
    @GetMapping("/pageable")
    public ResponseEntity<Page<LocationResponse>> getAllLocations(Pageable pageable) {
        Page<LocationResponse> locations = locationService.findAll(pageable);
        return ResponseEntity.ok(locations);
    }

    // Obtener una ubicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.findById(id));
    }

    // Crear nueva ubicación
    @PostMapping
    public ResponseEntity<LocationResponse> createLocation(@Valid @RequestBody LocationRequest locationRequest) {
        LocationResponse savedLocation = locationService.save(locationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }

    // Actualizar ubicación existente
    @PutMapping("/{id}")
    public ResponseEntity<LocationResponse> updateLocation(
            @PathVariable Long id,
            @Valid @RequestBody LocationRequest locationRequest) {
        LocationResponse updatedLocation = locationService.update(id, locationRequest);
        return ResponseEntity.ok(updatedLocation);
    }

    // Eliminación lógica o real de una ubicación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}