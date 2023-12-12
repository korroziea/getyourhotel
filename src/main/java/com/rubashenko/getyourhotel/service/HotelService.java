package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.Hotels;

import java.util.List;

public interface HotelService {
    Hotels createHotel(Hotels hotel);
    Hotels findHotel(Hotels hotel);
    List<Hotels> showAllHotels();
}
