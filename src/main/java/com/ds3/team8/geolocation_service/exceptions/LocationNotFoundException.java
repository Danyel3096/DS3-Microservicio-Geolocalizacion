package com.ds3.team8.geolocation_service.exceptions;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(Long id) {
        super("La ubicación con ID " + id + " no fue encontrada.");
    }
}
