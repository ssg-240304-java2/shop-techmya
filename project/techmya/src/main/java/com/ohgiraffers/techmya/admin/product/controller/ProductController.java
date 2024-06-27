package com.ohgiraffers.techmya.admin.product.controller;

import com.ohgiraffers.techmya.admin.product.model.dto.ProductAndProductPostDTO;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductCategoryDTO;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductDTO;
import com.ohgiraffers.techmya.admin.product.model.service.CategoryService;
import com.ohgiraffers.techmya.admin.product.model.service.ProductPostService;
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
    private final ProductPostService productPostService;

    public ProductController(ProductService productService, CategoryService categoryService, ProductPostService productPostService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.productPostService = productPostService;
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
                                RedirectAttributes rttr) {

        log.info("[ProductController] registProduct newProduct = {}, {}, {}", productName, productPrice, subCategoryId);

        productService.registNewProduct(productName, productPrice, subCategoryId);

        rttr.addFlashAttribute("successMessage", "신규 상품 등록에 성공하였습니다.");

        return "redirect:/product/productmain";
    }

    @GetMapping("/post")
    public String getAllSellPost(Model model) {

        // 데이터 베이스에서 판매 상품 전체 목록 조회
        List<ProductAndProductPostDTO> sellPostList = productPostService.getAllSellPost();
        log.info("[ProductController] getAllSellPost = {}", sellPostList);

        model.addAttribute("sellPostList", sellPostList);

        return "/admin/product/post";
    }

    @GetMapping("/postregist")
    public String registPostPage(Model model, @RequestParam(required = false) String productName) {

        // 데이터 베이스에서 상품 전체 목록 조회
        List<ProductDTO> productList = productService.getAllProduct(productName);
        log.info("[ProductController] registPostPage prductList = {}", productList);

        // 조회된 목록을 productList라는 이름으로 main.html에 리스트 객체로 전달
        model.addAttribute("productList", productList);

        // 데이터 베이스에서 상품 카테고리 대분류 조회
        List<String>parentCategories = categoryService.getAllParentCategories();
        log.info("[ProductController] getAllParentCategories parentCategories = {}", parentCategories);

        model.addAttribute("parentCategories", parentCategories);

        return "/admin/product/postregist";
    }

    @GetMapping("/postregist/{parentId}/subcategories")
    @ResponseBody
    public List<ProductCategoryDTO> getSubCategoriesPost(@PathVariable int parentId) {

        List<ProductCategoryDTO> categories = categoryService.getSubCategories(parentId);

        log.info("[ProductController] getSubCategories = {}", categories);

        return categories;
    }

    @GetMapping("/postregist/{subCategoryNo}/productList")
    @ResponseBody
    public List<ProductDTO> getAllProduct(@PathVariable int subCategoryNo) {

        List<ProductDTO> productList = productPostService.getAllProduct(subCategoryNo);

        log.info("[ProductController] getAllProduct = {}", productList);

        return productList;
    }

    @PostMapping("/postregist")
    public String registSellPost(@RequestParam("productName") int productNo,
                                 @RequestParam("productDesc") String productDesc,
                                 @RequestParam("productStatus") String productStatus,
                                 @RequestParam("shippingPeriod") int shippingPeriod,
                                 RedirectAttributes rttr) {

        log.info("[ProductController] registSellPost newPost = {}, {}, {}, {}", productNo, productDesc, productStatus, shippingPeriod);

        productPostService.registSellPost(productNo, productDesc, productStatus, shippingPeriod);

        rttr.addFlashAttribute("successMessage", "신규 판매 글 등록에 성공하였습니다.");

        return "redirect:/product/post";
    }
}