package io.github.omairsalam.spring6restmvc.Controller;

import io.github.omairsalam.spring6restmvc.model.Beer;
import io.github.omairsalam.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID id){
        log.debug("Get Beer By Id - in controller");
        return beerService.getBeerByID(id);
    }
}