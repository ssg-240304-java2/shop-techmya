package com.ohgiraffers.techmya.admin.order.model.service;

import com.ohgiraffers.techmya.admin.common.SelectCriteria;
import com.ohgiraffers.techmya.admin.order.model.dao.OrderListMapper;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService{

    private final OrderListMapper orderMapper;

    public OrderListServiceImpl(OrderListMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getOrderList() {
        return orderMapper.getOrderList();
    }

    /**
     * 총 게시글 수를 조회
     * @return
     */
    @Override
    public int selectTotalCount() {
        return orderMapper.selectTotalCount();
    }

    /**
     * 페이징 처리용
     * @param selectCriteria
     * @return
     */
    @Override
    public List<OrderDTO> findAllMenu(SelectCriteria selectCriteria) {
        selectCriteria.setStartRow(selectCriteria.getStartRow()-1);
        return orderMapper.findAllMenu(selectCriteria);
    }
}
