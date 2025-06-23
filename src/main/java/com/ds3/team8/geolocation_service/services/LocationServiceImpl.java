package com.ds3.team8.geolocation_service.services;


import com.ds3.team8.geolocation_service.dtos.LocationRequest;
import com.ds3.team8.geolocation_service.dtos.LocationResponse;
import com.ds3.team8.geolocation_service.entities.Location;
import com.ds3.team8.geolocation_service.exceptions.LocationNotFoundException;
import com.ds3.team8.geolocation_service.repositories.ILocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService {

    private final ILocationRepository locationRepository;

    public LocationServiceImpl(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Transactional
    @Override
    public LocationResponse save(LocationRequest request) {
        Location location = new Location();
        location.setLatitud(request.getLatitud());
        location.setLongitud(request.getLongitud());
        location.setTimestamp(request.getTimestamp());
        location.setIdPedido(request.getIdPedido());

        Location saved = locationRepository.save(location);
        return convertToResponse(saved);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

        locationRepository.delete(existingLocation);
    }

    // Actualiza una ubicación existente
    @Transactional
    @Override
    public LocationResponse update(Long id, LocationRequest request) {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

        existingLocation.setLatitud(request.getLatitud());
        existingLocation.setLongitud(request.getLongitud());
        existingLocation.setTimestamp(request.getTimestamp());
        existingLocation.setIdPedido(request.getIdPedido());

        Location updatedLocation = locationRepository.save(existingLocation);
        return convertToResponse(updatedLocation);
    }

    // Busca una ubicación por su ID
    @Transactional(readOnly = true)
    @Override
    public LocationResponse findById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

        return convertToResponse(location);
    }

    // Lista todas las ubicaciones
    @Transactional(readOnly = true)
    @Override
    public List<LocationResponse> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Transactional
    @Override
    public Page<LocationResponse> findAll(Pageable pageable) {
        return locationRepository.findAll(pageable)
                .map(this::convertToResponse);
    }

    private LocationResponse convertToResponse(Location location) {
        return new LocationResponse(
                location.getId(),
                location.getLatitud(),
                location.getLongitud(),
                location.getTimestamp(),
                location.getIdPedido()
        );
    }
}