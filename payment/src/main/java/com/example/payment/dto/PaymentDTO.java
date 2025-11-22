package com.example.payment.dto;

public class PaymentDTO {

    Long orderId;
    Double amount;
    String status;

    public PaymentDTO(Long orderId, Double amount, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
