package edu.icet.service.impl;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.entity.Customer;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    final private CustomerRepository customerRepository;

    private Customer toEntity(CustomerDTO customerDTO){
        Customer customer=new Customer();
        customer.setName(customerDTO.getName());
        customer.setCity(customerDTO.getCity());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }
    @Override
    public void save(CustomerDTO customerDTO) {
        customerRepository.save(toEntity(customerDTO));
    }
}
