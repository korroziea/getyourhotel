package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.HotelRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HotelRoomRepository extends JpaRepository<HotelRooms, Long> {
    HotelRooms findHotelRoomsById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE HotelRooms hr SET hr.rooms_number = :rooms_number, hr.bathrooms_number = :bathrooms_number, hr.loggia = :loggia, hr.balcony = :balcony, hr.vault = :vault, hr.fridge = :fridge WHERE hr.id = :id")
    void updateHotelRoomsById(@Param("id") Long id, @Param("rooms_number") Integer rooms_number,
                              @Param("bathrooms_number") Integer bathrooms_number, @Param("loggia") Boolean loggia,
                              @Param("balcony") Boolean balcony, @Param("vault") Boolean vault, @Param("fridge") Boolean fridge);
}