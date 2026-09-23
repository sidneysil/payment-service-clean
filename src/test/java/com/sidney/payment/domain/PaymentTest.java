package com.sidney.payment.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class PaymentTest {

    @Test
    void shouldCreatePaymentWithPendingStatus() {

        Payment payment = new Payment(
                new BigDecimal("150.00"),
                PaymentType.CREDIT
        );

        assertThat(payment.getAmount())
                .isEqualByComparingTo("150.00");

        assertThat(payment.getType())
                .isEqualTo(PaymentType.CREDIT);

        assertThat(payment.getStatus())
                .isEqualTo(PaymentStatus.PENDING);
    }
    
    @Test
    void shouldRejectPaymentWithZeroAmount() {

        assertThatThrownBy(() ->
                new Payment(
                        BigDecimal.ZERO,
                        PaymentType.CREDIT
                )
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Payment amount must be greater than zero");
    }
    
}
