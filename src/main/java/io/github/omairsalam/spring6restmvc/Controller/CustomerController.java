package io.github.omairsalam.spring6restmvc.Controller;

import io.github.omairsalam.spring6restmvc.model.Customer;
import io.github.omairsalam.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @PatchMapping("{customerID}")
    public ResponseEntity updateCustomerPatchByID(@PathVariable("customerID") UUID customerID, @RequestBody Customer customer){
        customerService.updateCustomerPatchByID(customerID, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerID}")
    public ResponseEntity deleteById(@PathVariable("customerID") UUID customerID){
        customerService.deleteByID(customerID);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerID}")
    public ResponseEntity handlePut(@PathVariable("customerID") UUID customerID, @RequestBody Customer customer){
        customerService.updateByID(customerID, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer newCustomer){
        Customer savedCustomer = customerService.newCustomer(newCustomer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.listCustomers();
    }

    @RequestMapping(method = RequestMethod.GET, path = "{customerID}")
    public Customer getCustomerByID(@PathVariable("customerID") UUID id){
        return customerService.getCustomerById(id);
    }

}
