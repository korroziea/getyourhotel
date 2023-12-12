package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HotelRepository extends JpaRepository<Hotels, Long> {
    Hotels findHotelByTitle(String title);
    Hotels findHotelById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Hotels h SET h.title = :title, h.rating = :rating, h.country = :country, h.city = :city, h.distanceToSea = :distanceToSea, h.wifi = :wifi, h.conditioner = :conditioner WHERE h.id = :id")
    void updateHotelById(@Param("id") Long id, @Param("title") String title, @Param("rating") Double rating,
                         @Param("country") String country, @Param("city") String city, @Param("distanceToSea") Double distanceToSea,
                         @Param("wifi") Boolean wifi, @Param("conditioner") Boolean conditioner);
}
