package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Hotels;
import com.rubashenko.getyourhotel.repository.HotelRepository;
import com.rubashenko.getyourhotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotels createHotel(Hotels hotel) {
        hotel.setUser_id(6L);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotels findHotel(Hotels hotel) {
        return hotelRepository.findHotelByTitle(hotel.getTitle());
    }

    @Override
    public List<Hotels> showAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotels showOneHotel(Long id) {
        return hotelRepository.findHotelById(id);
    }

    @Override
    public void updateHotel(Long id, Hotels updatedHotel) {
        hotelRepository.updateHotelById(id, updatedHotel.getTitle(), updatedHotel.getRating(), updatedHotel.getCountry(),
                updatedHotel.getCity(), updatedHotel.getDistanceToSea(), updatedHotel.getWifi(), updatedHotel.getConditioner());
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
