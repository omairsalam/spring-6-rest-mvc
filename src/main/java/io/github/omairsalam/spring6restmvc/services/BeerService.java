package io.github.omairsalam.spring6restmvc.services;

import io.github.omairsalam.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerByID(UUID id);
}
