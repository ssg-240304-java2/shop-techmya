package com.ohgiraffers.techmya.admin.order.model.dao;

import com.ohgiraffers.techmya.admin.common.SelectCriteria;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDetailDTO;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDetailListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderListMapper {
    List<OrderDTO> getOrderList();

    int selectTotalCount();

    List<OrderDTO> findAllOrder(SelectCriteria selectCriteria);

    int checkOrderhasOptions(int orderNo);

    List<OrderDetailDTO> detailListOpt(int orderNo);

}
