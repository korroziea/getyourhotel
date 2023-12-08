package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Hotel;
import com.rubashenko.getyourhotel.repository.HotelRepository;
import com.rubashenko.getyourhotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository<Hotel> hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.create(hotel);
    }

    @Override
    public Hotel findHotel(Long id) {
        return hotelRepository.get(id);
    }
}
