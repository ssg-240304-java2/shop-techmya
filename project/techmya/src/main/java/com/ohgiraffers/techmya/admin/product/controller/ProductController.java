package com.ohgiraffers.techmya.admin.product.controller;

import com.ohgiraffers.techmya.admin.product.model.dto.ProductCategoryDTO;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductDTO;
import com.ohgiraffers.techmya.admin.product.model.service.CategoryService;
import com.ohgiraffers.techmya.admin.product.model.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/productmain")
    public String getAllProduct(Model model, @RequestParam(required = false) String productName) {
        log.info("[ProductController] getAllProduct productName = {}", productName);

        // 데이터 베이스에서 상품 전체 목록 조회
        List<ProductDTO> productList = productService.getAllProduct(productName);
        log.info("[ProductController] getAllProduct prductList = {}", productList);

        // 조회된 목록을 productList라는 이름으로 main.html에 리스트 객체로 전달
        model.addAttribute("productList", productList);

        return "/admin/product/productmain";
    }

    @GetMapping("/regist")
    public String parentCategories(Model model) {

        List<String>parentCategories = categoryService.getAllParentCategories();
        log.info("[ProductController] getAllParentCategories parentCategories = {}", parentCategories);

        model.addAttribute("parentCategories", parentCategories);

        return "/admin/product/regist";
    }

    @GetMapping("/regist/{parentId}/subcategories")
    @ResponseBody
    public List<ProductCategoryDTO> getSubCategories(@PathVariable int parentId) {

        List<ProductCategoryDTO> categories = categoryService.getSubCategories(parentId);

        log.info("[ProductController] getSubCategories = {}", categories);

        return categories;
    }

    @PostMapping("/regist")
    public String registProduct(@RequestParam("productName") String productName,
                                @RequestParam("productPrice") int productPrice,
                                @RequestParam("subCategory") int subCategoryId,
                                RedirectAttributes rttr, Model model) {

        log.info("[ProductController] registProduct newProduct = {}, {}, {}", productName, productPrice, subCategoryId);

        productService.registNewProduct(productName, productPrice, subCategoryId);

        rttr.addFlashAttribute("successMessage", "신규 상품 등록에 성공하였습니다.");

        return "redirect:/product/productmain";
    }
}