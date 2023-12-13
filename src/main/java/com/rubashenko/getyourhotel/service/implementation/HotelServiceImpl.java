package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Hotel;
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
    public Hotel createHotel(Hotel hotel) {
        hotel.setUser_id(6L);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel findHotelByTitle(String title) {
        return hotelRepository.findHotelByTitle(title);
    }

    @Override
    public List<Hotel> showAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel showOneHotel(Long id) {
        return hotelRepository.findHotelById(id);
    }

    @Override
    public void updateHotel(Long id, Hotel updatedHotel) {
        hotelRepository.updateHotelById(id, updatedHotel.getTitle(), updatedHotel.getRating(), updatedHotel.getCountry(),
                updatedHotel.getCity(), updatedHotel.getDistanceToSea(), updatedHotel.getWifi(), updatedHotel.getConditioner());
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
