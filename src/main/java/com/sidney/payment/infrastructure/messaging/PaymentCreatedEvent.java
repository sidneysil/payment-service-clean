package com.sidney.payment.infrastructure.messaging;

import java.math.BigDecimal;
import java.util.UUID;

import com.sidney.payment.domain.PaymentStatus;
import com.sidney.payment.domain.PaymentType;

public record PaymentCreatedEvent(
        UUID paymentId,
        BigDecimal amount,
        PaymentType type,
        PaymentStatus status) {
}