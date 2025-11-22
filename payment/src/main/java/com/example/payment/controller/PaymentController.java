package com.example.payment.controller;

import com.example.payment.dto.PaymentDTO;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/getAll")
    public List<PaymentDTO> getAllPayments(){
         return paymentService.listPayments();
    }

}
