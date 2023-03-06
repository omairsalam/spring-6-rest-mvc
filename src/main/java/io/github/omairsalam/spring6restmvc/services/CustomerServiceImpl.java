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

    @Override
    public Customer newCustomer(Customer newCustomer){
        Customer savedCustomer = Customer.builder()
                .customerName(newCustomer.getCustomerName())
                .version(newCustomer.getVersion())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .id(UUID.randomUUID())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateByID(UUID customerID, Customer customer) {
        Customer existing = customerMap.get(customerID);
        existing.setCustomerName(customer.getCustomerName());
        existing.setVersion(customer.getVersion());
    }

    @Override
    public void deleteByID(UUID customerID) {
        customerMap.remove(customerID);
    }

    @Override
    public void updateCustomerPatchByID(UUID customerID, Customer customer) {
        if (customer.getCustomerName() != null && !customer.getCustomerName().isEmpty()){
            customerMap.get(customerID).setCustomerName(customer.getCustomerName());
        }
    }
}
