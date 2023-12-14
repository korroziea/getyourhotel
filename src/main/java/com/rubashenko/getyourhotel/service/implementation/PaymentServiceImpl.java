package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Payment;
import com.rubashenko.getyourhotel.repository.PaymentRepository;
import com.rubashenko.getyourhotel.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
