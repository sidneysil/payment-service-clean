package com.sidney.payment.usecase;

import java.math.BigDecimal;

import com.sidney.payment.domain.Payment;
import com.sidney.payment.domain.PaymentType;

public interface CreatePaymentUseCase {
	
    Payment create(BigDecimal amount, PaymentType type);


}
