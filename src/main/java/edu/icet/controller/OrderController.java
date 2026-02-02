package edu.icet.controller;

import edu.icet.model.dto.PlaceOrderRequestDTO;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-info")
@RequiredArgsConstructor

public class OrderController {
    final private OrderService orderService;

    @PostMapping("/place-order")
    public void placeOrder(@RequestBody PlaceOrderRequestDTO placeOrderRequestDTO){
        orderService.placeOrder(placeOrderRequestDTO);
    }

}
