package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
