package io.github.omairsalam.spring6restmvc.Controller;

import io.github.omairsalam.spring6restmvc.model.Beer;
import io.github.omairsalam.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@Controller
@AllArgsConstructor
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id){
        log.debug("Get Beer By Id - in controller");
        return beerService.getBeerByID(id);
    }
}