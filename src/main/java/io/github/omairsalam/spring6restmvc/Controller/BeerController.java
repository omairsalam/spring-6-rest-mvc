package io.github.omairsalam.spring6restmvc.Controller;

import io.github.omairsalam.spring6restmvc.model.Beer;
import io.github.omairsalam.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PatchMapping("{beerID}")
    public ResponseEntity updateBeerPatchById(@PathVariable("beerID") UUID beerID, @RequestBody Beer beer){
        beerService.patchBeerById(beerID, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerID}")
    public ResponseEntity deleteById(@PathVariable ("beerID") UUID beerID){
        beerService.deleteByID(beerID);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerID}")
    public ResponseEntity updateByID(@PathVariable("beerID") UUID beerID, @RequestBody Beer beer){

        beerService.updateBeerByID(beerID, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();

        headers.add("location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

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