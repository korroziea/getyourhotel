package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.HotelRoom;
import com.rubashenko.getyourhotel.service.HotelRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/hotel")
@RequiredArgsConstructor
public class HotelRoomResource {
    private final HotelRoomService hotelRoomService;

    @GetMapping("/{hotel_id}/new")
    public String newHotelRoom(@ModelAttribute("hotelRoom") HotelRoom hotelRoom) {
        return "hotel/rooms/new";
    }

    @PostMapping("/{hotel_id}/create")
    public String saveHotelRoom(@PathVariable("hotel_id") Long hotel_id, @ModelAttribute("hotelRoom") HotelRoom hotelRoom) {
        hotelRoom.setHotel_id(hotel_id);
        hotelRoomService.createHotelRoom(hotelRoom);
        return "redirect:room";
    }

    @GetMapping("/{hotel_id}/room")
    public String showHotelRooms(@PathVariable("hotel_id") Long hotel_id, Model model) {
        List<HotelRoom> hotelRooms = hotelRoomService.showAllHotelRooms();
        model.addAttribute("hotelRooms", hotelRooms);
        return "hotel/rooms/showAll";
    }
}
