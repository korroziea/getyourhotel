package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.HotelRooms;

import java.util.List;

public interface HotelRoomService {
    HotelRooms createHotelRoom (HotelRooms hotelRoom);
    List<HotelRooms> showAllHotelRooms();
    HotelRooms showOneHotelRoom(Long id);
    void updateHotelRoom(Long id, HotelRooms updatedHotel);
    void deleteHotelRoom(Long id);
}
