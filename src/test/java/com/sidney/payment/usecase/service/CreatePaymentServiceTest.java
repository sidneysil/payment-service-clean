package com.sidney.payment.usecase.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.sidney.payment.domain.Payment;
import com.sidney.payment.domain.PaymentStatus;
import com.sidney.payment.domain.PaymentType;
import com.sidney.payment.usecase.gateway.PaymentEventPublisher;
import com.sidney.payment.usecase.gateway.PaymentRepository;

class CreatePaymentServiceTest {

    @Test
    void shouldCreateSaveAndPublishPayment() {

        PaymentRepository repository =
                Mockito.mock(PaymentRepository.class);

        PaymentEventPublisher publisher =
                Mockito.mock(PaymentEventPublisher.class);

        when(repository.save(any(Payment.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        CreatePaymentService service =
                new CreatePaymentService(repository, publisher);

        Payment result = service.create(
                new BigDecimal("150.00"),
                PaymentType.CREDIT
        );

        assertThat(result.getAmount())
                .isEqualByComparingTo("150.00");

        assertThat(result.getStatus())
                .isEqualTo(PaymentStatus.PENDING);

        verify(repository).save(result);

        verify(publisher).publish(result);
    }
}