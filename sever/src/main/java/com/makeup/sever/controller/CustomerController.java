package com.makeup.sever.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import com.makeup.sever.entity.Customer;
import com.makeup.sever.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
        private CustomerRepository customerRepository;
        public CustomerController(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }
@RequestMapping("/customer")
        public Collection<Customer> customer() {
        return customerRepository.findAll().stream()
                .collect(Collectors.toList());
    }
}
