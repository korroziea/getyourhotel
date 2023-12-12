package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface HotelRepository extends JpaRepository<Hotels, Long> {
    Hotels findHotelByTitle(String title);
}
