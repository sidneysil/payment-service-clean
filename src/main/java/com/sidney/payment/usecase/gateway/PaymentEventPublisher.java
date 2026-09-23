package com.sidney.payment.usecase.gateway;
import com.sidney.payment.domain.Payment;

public interface PaymentEventPublisher {

    void publish(Payment payment);

}
