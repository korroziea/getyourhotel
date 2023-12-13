package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel findHotelByTitle(String title);
    List<Hotel> showAllHotels();
    Hotel showOneHotel(Long id);
    void updateHotel(Long id, Hotel updatedHotel);
    void deleteHotel(Long id);
}
