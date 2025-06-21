package com.ds3.team8.geolocation_service.services;

import com.ds3.team8.geolocation_service.dtos.LocationRequest;
import com.ds3.team8.geolocation_service.dtos.LocationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocationService {
    LocationResponse save(LocationRequest locationRequest);
    void delete(Long id);
    LocationResponse findById(Long id);
    LocationResponse update(Long id, LocationRequest locationRequest);
    List<LocationResponse> findAll();
    Page<LocationResponse> findAll(Pageable pageable);
}
