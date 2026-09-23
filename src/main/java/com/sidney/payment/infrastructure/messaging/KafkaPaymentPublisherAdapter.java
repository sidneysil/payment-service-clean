package com.sidney.payment.infrastructure.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.sidney.payment.domain.Payment;
import com.sidney.payment.usecase.gateway.PaymentEventPublisher;

@Component
public class KafkaPaymentPublisherAdapter
        implements PaymentEventPublisher {

    private final KafkaTemplate<String, PaymentCreatedEvent> kafkaTemplate;

    public KafkaPaymentPublisherAdapter(
            KafkaTemplate<String, PaymentCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(Payment payment) {

        PaymentCreatedEvent event = new PaymentCreatedEvent(
                payment.getId(),
                payment.getAmount(),
                payment.getType(),
                payment.getStatus()
        );

        kafkaTemplate.send("payment-created", event);
    }
}