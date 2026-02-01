package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customerInfo")

@RequiredArgsConstructor
public class CustomerController {
    final private CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.save(customerDTO);
    }
}
