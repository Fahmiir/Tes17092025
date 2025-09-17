package com.example.payment.listener;

import com.example.payment.dto.OrderDTO;
import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.criteria.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentListener {

    private final PaymentRepository paymentRepository;

    public PaymentListener(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void consume(OrderDTO event) {
        System.out.println("Received Order Event: " + event.getOrderId());

        // Simulasi proses pembayaran
        Payment payment = new Payment();
        payment.setOrderId(event.getOrderId());
        payment.setAmount(event.getTotalAmount());
        payment.setStatus("COMPLETED");

        paymentRepository.save(payment);

        System.out.println("Payment created for Order: " + event.getOrderId());
    }

}
