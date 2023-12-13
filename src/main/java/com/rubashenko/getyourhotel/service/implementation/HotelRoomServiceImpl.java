package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.HotelRoom;
import com.rubashenko.getyourhotel.repository.HotelRoomRepository;
import com.rubashenko.getyourhotel.service.HotelRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelRoomServiceImpl implements HotelRoomService {
    private final HotelRoomRepository hotelRoomRepository;

    @Override
    public HotelRoom createHotelRoom(HotelRoom hotelRoom) {
        return hotelRoomRepository.save(hotelRoom);
    }

//    @Override
//    public List<HotelRoom> showAllHotelRooms(Long hotel_id) {
//        return hotelRoomRepository.findHotelRoomsByHotel_id(hotel_id);
//    }

    @Override
    public List<HotelRoom> showAllHotelRooms() {
        return hotelRoomRepository.findAll();
    }

    @Override
    public HotelRoom showOneHotelRoom(Long id) {
        return hotelRoomRepository.findHotelRoomsById(id);
    }

    @Override
    public void updateHotelRoom(Long id, HotelRoom updatedHotelRoom) {
        hotelRoomRepository.updateHotelRoomsById(id, updatedHotelRoom.getRooms_number(), updatedHotelRoom.getBathrooms_number(),
                updatedHotelRoom.getLoggia(), updatedHotelRoom.getBalcony(), updatedHotelRoom.getVault(), updatedHotelRoom.getFridge());
    }

    @Override
    public void deleteHotelRoom(Long id) {
        hotelRoomRepository.deleteById(id);
    }
}
