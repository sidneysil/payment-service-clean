package com.sidney.payment.usecase.service;

import java.math.BigDecimal;

import com.sidney.payment.domain.Payment;
import com.sidney.payment.domain.PaymentType;
import com.sidney.payment.usecase.CreatePaymentUseCase;
import com.sidney.payment.usecase.gateway.PaymentEventPublisher;
import com.sidney.payment.usecase.gateway.PaymentRepository;

public class CreatePaymentService implements CreatePaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final PaymentEventPublisher paymentEventPublisher;

    public CreatePaymentService(
            PaymentRepository paymentRepository,
            PaymentEventPublisher paymentEventPublisher) {

        this.paymentRepository = paymentRepository;
        this.paymentEventPublisher = paymentEventPublisher;
    }

    @Override
    public Payment create(BigDecimal amount, PaymentType type) {

        Payment payment = new Payment(amount, type);

        Payment savedPayment = paymentRepository.save(payment);

        paymentEventPublisher.publish(savedPayment);

        return savedPayment;
    }
}