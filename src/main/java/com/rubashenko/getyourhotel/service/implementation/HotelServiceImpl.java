package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Hotels;
import com.rubashenko.getyourhotel.repository.HotelRepository;
import com.rubashenko.getyourhotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotels createHotel(Hotels hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotels findHotel(Hotels hotel) {
        return hotelRepository.findHotelByTitle(hotel);
    }
}
