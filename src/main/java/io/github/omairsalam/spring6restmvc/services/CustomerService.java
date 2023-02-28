package io.github.omairsalam.spring6restmvc.services;

import io.github.omairsalam.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID id);
    List<Customer> listCustomers();
}
