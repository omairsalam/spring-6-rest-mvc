package io.github.omairsalam.spring6restmvc.services;

import io.github.omairsalam.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, Customer> customerMap;

    public CustomerServiceImpl(){

        customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Alfred Marshal")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .version("1.0")
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("John Smith")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .version("1.0")
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Emi Martinez")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .version("1.0")
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
