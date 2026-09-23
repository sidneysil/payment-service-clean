package com.sidney.payment.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.sidney.payment.domain.Payment;
import com.sidney.payment.usecase.gateway.PaymentRepository;

@Repository
public class JpaPaymentRepositoryAdapter
        implements PaymentRepository {

    private final SpringDataPaymentRepository springDataPaymentRepository;

    public JpaPaymentRepositoryAdapter(
            SpringDataPaymentRepository springDataPaymentRepository) {

        this.springDataPaymentRepository = springDataPaymentRepository;
    }

    @Override
    public Payment save(Payment payment) {

        PaymentEntity entity = new PaymentEntity(
                payment.getId(),
                payment.getAmount(),
                payment.getType(),
                payment.getStatus(),
                payment.getCreatedAt()
        );

        springDataPaymentRepository.save(entity);

        return payment;
    }
}
