package com.example.payment.service;

import com.example.payment.dto.PaymentDTO;
import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;



    public List<PaymentDTO> listPayments (){

        List<Payment> listPayments = paymentRepository.findAll();
        List<PaymentDTO> payments = listPayments.stream()
                .filter(p -> "COMPLETED".equals(p.getStatus()))
                .sorted(Comparator.comparing(Payment::getAmount).reversed()) // urutkan dari nominal tertinggi
                .map(p -> new PaymentDTO(
                        p.getOrderId(),
                        p.getAmount(),
                        p.getStatus()
                ))
                .collect(Collectors.toList());

        return payments;
    }
}
