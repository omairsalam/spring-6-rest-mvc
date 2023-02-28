package io.github.omairsalam.spring6restmvc.Controller;

import io.github.omairsalam.spring6restmvc.model.Customer;
import io.github.omairsalam.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.listCustomers();
    }

    @RequestMapping(method = RequestMethod.GET, path = "{customerID}")
    public Customer getCustomerByID(@PathVariable("customerID") UUID id){
        return customerService.getCustomerById(id);
    }

}
