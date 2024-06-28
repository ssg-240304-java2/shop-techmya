package com.ohgiraffers.techmya.admin.order.model.service;

import com.ohgiraffers.techmya.admin.common.SelectCriteria;
import com.ohgiraffers.techmya.admin.order.model.dao.OrderListMapper;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDetailDTO;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDetailListDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public List<OrderDTO> findAllOrder(SelectCriteria selectCriteria) {
        selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);

        // 주문 정보를 돌려보내기 전, 해당 주문 번호의 상세 주문 정보를 추가로 담아준다.
        // 옵션 정보가 있는가에 따라서 서로 다른 계산식을 가짐
        // 옵션이 있는지를 먼저 확인

        List<OrderDTO> order = orderMapper.findAllOrder(selectCriteria);

        int orderNo = 0;

        for (int i = 0; i < order.size(); i++) {

            orderNo = order.get(i).getOrderNo();

            List<OrderDetailDTO> detailList = orderMapper.detailListOpt(orderNo);
            order.get(i).setOrderDetailList(detailList);
//
//            if(checkOrderhasOptions(orderNo)){
//                // 옵션 정보가 있다면 옵션 계산식을 활용
//                List<OrderDetailDTO> detailList = orderMapper.detailListOpt(orderNo);
//                order.get(i).setOrderDetailList(detailList);
//            } else {
//                List<OrderDetailDTO> detailList = orderMapper.detailList(orderNo);
//                order.get(i).setOrderDetailList(detailList);
//            }
        }
//        return orderMapper.findAllOrder(selectCriteria);
            return order;
        }

//    private boolean checkOrderhasOptions(int orderNo) {
//
//        int result = 0;
//        result = orderMapper.checkOrderhasOptions(orderNo);
//
//        return result > 0 ? true : false;
//    }

}
