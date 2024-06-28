package com.ohgiraffers.techmya.admin.order.model.dto;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailListDTO {

    private List<OrderDetailDTO> orderDetail;
}
