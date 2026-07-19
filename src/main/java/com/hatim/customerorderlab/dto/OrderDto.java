package com.hatim.customerorderlab.dto;

import com.hatim.customerorderlab.entity.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String orderNumber;
    private BigDecimal amount;
    private OrderStatus status;
    private LocalDate orderDate;
    private Long customerId;

}
