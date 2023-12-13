package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.HotelRoom;

import java.util.List;

public interface HotelRoomService {
    HotelRoom createHotelRoom (HotelRoom hotelRoom);
//    List<HotelRoom> showAllHotelRooms(Long hotel_id);
    List<HotelRoom> showAllHotelRooms();
    HotelRoom showOneHotelRoom(Long id);
    void updateHotelRoom(Long id, HotelRoom updatedHotel);
    void deleteHotelRoom(Long id);
}
