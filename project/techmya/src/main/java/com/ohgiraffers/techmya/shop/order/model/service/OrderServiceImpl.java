package com.ohgiraffers.techmya.shop.order.model.service;

import com.ohgiraffers.techmya.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.techmya.shop.order.model.dto.OrderCartDTO;
import com.ohgiraffers.techmya.shop.order.model.dao.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 상품의 가격 정보 불러오기
     * @param product
     * @return
     */
    @Override
    public int getPriceByProductNo(OrderCartDTO product) {
        log.info("[OrderServiceImpl]  getPriceByProductNo product : {}", product);
        int productPrice = orderMapper.getProductPriceByProductNo(product);
        int optionPrice = orderMapper.getOptionPriceByOptionNo(product);
        int amount = product.getDetailOrderAmount();
        System.out.println("productPrice = " + productPrice);
        System.out.println("optionPrice = " + optionPrice);
        System.out.println("amount = " + amount);
        int result;
        result = (productPrice + optionPrice) * amount;
        System.out.println("result = " + result);
        return result;
    }

    /**
     * 장바구니에 상품을 추가 update or insert
     * @param product
     */
    @Override
    @Transactional
    public void updateCart(OrderCartDTO product) {

        int result = 0;
        // 새로 추가하는 상품의 정보가 이전에 존재했는지 확인
        int productNo;
        int optionNo;
        productNo = orderMapper.checkProductAmount(product);

        if(hasOptions(product.getProductNo())){
            optionNo = orderMapper.checkOptionAmount(product);
            if(productNo >= 1 && optionNo >= 1 ){
                // 동일한 상품명과 옵션명 -> update
                orderMapper.updateCartWithOpt(product);
            } else {
                if(productNo >= 1) {
                // 옵션이 원래 없는 동일한 상품 -> update
                orderMapper.updateCartNoOpt(product);
                }
            }
            // 그외는 장바구니 신규 상품 -> insert
            orderMapper.registNewCart(product);
        }

        // 변경된 총 주문 가격 정보를 업데이트
        orderMapper.updateOrder(product);
    }

    @Override
    public List<OrderDTO> findAllOrderProduct() {
        return orderMapper.findAllOrderProduct();
    }

    private boolean hasOptions(int productNo) {
        int result = 0;
        result = orderMapper.countOptions(productNo);
        return result > 1 ? true : false;
    }

    /**
     * 장바구니에 상품 한 개를 INSERT
     * 그 후 해당 아이디 정보를 가지고 돌아옴
     * @param product
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int registNewCart(OrderCartDTO product) {

        int result;

        orderMapper.registNewOrder(product);
        int lastNo = orderMapper.getLastOrderNo();
        product.setOrderNo(lastNo);

        // 최종 저장할 정보
        log.info("[OrderServiceImpl] registNewCart product : {}", product);

        // 장바구니 저장
        orderMapper.registNewCart(product);
        result = orderMapper.getLastOrderNo();

        return  result;
    }


}
