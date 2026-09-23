package com.sidney.payment.usecase.gateway;

import com.sidney.payment.domain.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);

	
}
