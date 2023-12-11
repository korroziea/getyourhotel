package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.Hotels;

public interface HotelService {
    Hotels createHotel(Hotels hotel);
    Hotels findHotel(Hotels hotel);
}
