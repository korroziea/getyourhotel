package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findHotelByTitle(String title);
    Hotel findHotelById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Hotel h SET h.title = :title, h.rating = :rating, h.country = :country, h.city = :city, h.distanceToSea = :distanceToSea, h.wifi = :wifi, h.conditioner = :conditioner WHERE h.id = :id")
    void updateHotelById(@Param("id") Long id, @Param("title") String title, @Param("rating") Double rating,
                         @Param("country") String country, @Param("city") String city, @Param("distanceToSea") Double distanceToSea,
                         @Param("wifi") Boolean wifi, @Param("conditioner") Boolean conditioner);
}
