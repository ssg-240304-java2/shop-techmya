package com.ohgiraffers.techmya.admin.stock.model.dto;


public class inputStockDTO {

    private int stockNo;
    private int productNo;
    private int productOptionNo;
    private int stockQuantity;

    public inputStockDTO() {
    }

    public inputStockDTO(int productNo, int productOptionNo, int stockQuantity) {
        this.productNo = productNo;
        this.productOptionNo = productOptionNo;
        this.stockQuantity = stockQuantity;
    }


    public int getStockNo() {
        return stockNo;
    }

    public void setStockNo(int stockNo) {
        this.stockNo = stockNo;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getProductOptionNo() {
        return productOptionNo;
    }

    public void setProductOptionNo(int productOptionNo) {
        this.productOptionNo = productOptionNo;
    }
}