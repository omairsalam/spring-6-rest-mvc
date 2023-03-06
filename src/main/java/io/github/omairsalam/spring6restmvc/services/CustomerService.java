package io.github.omairsalam.spring6restmvc.services;

import io.github.omairsalam.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID id);
    List<Customer> listCustomers();

    Customer newCustomer(Customer newCustomer);

    void updateByID(UUID customerID, Customer customer);

    void deleteByID(UUID customerID);

    void updateCustomerPatchByID(UUID customerID, Customer customer);
}
