package edu.icet.service.impl;

import edu.icet.exception.InsufficientStockException;
import edu.icet.model.dto.OrderDetailDTO;
import edu.icet.model.dto.PlaceOrderRequestDTO;
import edu.icet.model.entity.Book;
import edu.icet.model.entity.Order;
import edu.icet.model.entity.OrderDetail;
import edu.icet.repository.BookRepository;
import edu.icet.repository.CustomerRepository;
import edu.icet.repository.OrderDetailsRepository;
import edu.icet.repository.OrderRepository;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private OrderDetailsRepository orderDetailsRepository;
    final private OrderRepository orderRepository;
    final private BookRepository bookRepository;
    final private CustomerRepository customerRepository;

    private OrderDetail toEntity(OrderDetailDTO dto, Order order) {
        OrderDetail detail = new OrderDetail();
        detail.setQty(dto.getQty());
        detail.setBook(bookRepository.getReferenceById(dto.getIsbn()));
        detail.setOrder(order);
        return detail;
    }

    private Order toEntity(PlaceOrderRequestDTO placeOrderRequestDTO){
        Order order=new Order();
        order.setDate(placeOrderRequestDTO.getDate());
        order.setCustomer(customerRepository.getReferenceById(placeOrderRequestDTO.getCustomerId()));
        return order;
    }

    @Transactional
    @Override
    public void placeOrder(PlaceOrderRequestDTO dto) {

        Order savedOrder = orderRepository.save(toEntity(dto));

        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDTO detailDTO : dto.getOrderDetails()) {

            Book book=bookRepository.getReferenceById(detailDTO.getIsbn());

            if (book.getStock() < detailDTO.getQty()) {
                throw new InsufficientStockException(
                        "Not enough stock for book ISBN: " + detailDTO.getIsbn()
                );
            }

            book.setStock(book.getStock()-detailDTO.getQty());

            orderDetails.add(toEntity(detailDTO,savedOrder));
        }
        orderDetailsRepository.saveAll(orderDetails);
    }
}
