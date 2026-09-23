package com.sidney.payment.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private UUID id;
    private BigDecimal amount;
    private PaymentType type;
    private PaymentStatus status;
    private LocalDateTime createdAt;

    public Payment(BigDecimal amount, PaymentType type) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                "Payment amount must be greater than zero"
            );
        }

        if (type == null) {
            throw new IllegalArgumentException(
                "Payment type is required"
            );
        }

        this.id = UUID.randomUUID();
        this.amount = amount;
        this.type = type;
        this.status = PaymentStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }
    public UUID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentType getType() {
        return type;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}