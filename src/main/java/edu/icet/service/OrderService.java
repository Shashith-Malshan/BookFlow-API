package edu.icet.service;

import edu.icet.model.dto.PlaceOrderRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {


    void placeOrder(PlaceOrderRequestDTO placeOrderRequestDTO);
}
