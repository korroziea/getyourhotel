package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
