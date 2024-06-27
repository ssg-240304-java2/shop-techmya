package com.ohgiraffers.techmya.admin.order.controller;

import com.ohgiraffers.techmya.admin.common.SelectCriteria;
import com.ohgiraffers.techmya.admin.common.paging.Pagenation;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.techmya.admin.order.model.service.OrderListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderListController {

    private final OrderListService orderService;

    public OrderListController(OrderListService orderService) {
        this.orderService = orderService;
    }

//      일반 전체 조회
//    @GetMapping("/ordermain")
//    public String allOrderList(Model model) {
//
//        List<OrderDTO> orderList = orderService.getOrderList();
//        log.info("[OrderListController] orderList >>>>>>>>>>>>>>>>>> {}", orderList);
//
//        model.addAttribute("orderList", orderList);
//
//        return "admin/order/ordermain";
//    }
//

    /**
     * 페이징 전체 조회
     * @param model
     * @param pageNo
     * @return
     */
    @GetMapping("/ordermain")
    public String findMenuList(Model model,
                               @RequestParam(value = "currentPage", defaultValue = "1") int pageNo ){

        // 전체 갯수
        int totalCount = orderService.selectTotalCount();
        log.info("[OrderListController] findMenuList  totalCount >>>>>>>>>>> {}", totalCount);

        // 한 페이지에 보여줄 게시물 수
        int limit = 10;

        // 한번에 보여질 페이징 버튼의 갯수
        int buttonAmount = 5;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);

        List<OrderDTO> orderList = orderService.findAllMenu(selectCriteria);
        log.info("[MenuController] menuList : {}", orderList);

        model.addAttribute("orderList", orderList);
        model.addAttribute("selectCriteria", selectCriteria);   // 모든 페이지의 정보

        return "admin/order/ordermain";
    }
}
