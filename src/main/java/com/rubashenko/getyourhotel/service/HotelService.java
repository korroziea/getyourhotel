package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.Hotel;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel findHotel(Long id);
}
