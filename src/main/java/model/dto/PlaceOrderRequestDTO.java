package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.entity.OrderDetails;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderRequestDTO {
    private Date date;
    private Long customerId;

    private ArrayList<OrderDetails> orderDetails=new ArrayList<>();
}
