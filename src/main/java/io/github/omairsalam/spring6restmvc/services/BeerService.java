package io.github.omairsalam.spring6restmvc.services;

import io.github.omairsalam.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerByID(UUID id);
}
