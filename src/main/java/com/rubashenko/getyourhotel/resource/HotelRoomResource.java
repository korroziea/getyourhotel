package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Hotel;
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

    @GetMapping("/{hotel_id}/room/{id}")
    public String showHotelRooms(@PathVariable("hotel_id") Long hotel_id, @PathVariable("id") Long id, Model model) {
        HotelRoom hotelRoom = hotelRoomService.showOneHotelRoom(id);
        model.addAttribute("hotelRoom", hotelRoom);
        model.addAttribute("hotel_id", hotel_id);
        return "hotel/rooms/showOne";
    }

    @GetMapping("/{hotel_id}/room/search/{title}")
    public String searchHotelRoomByTitle(@PathVariable("hotel_id") Long hotel_id, @PathVariable("title") String title, Model model) {
        HotelRoom hotelRoom = hotelRoomService.findHotelRoomByTitle(title);
        Long id = hotelRoom.getId();
        model.addAttribute("hotelRoom", hotelRoom);
        return "redirect:/hotel/{hotel_id}/room/" + id;
    }

    @GetMapping("/{hotel_id}/room/{id}/edit")
    public String editHotelRoomForm(@PathVariable("hotel_id") Long hotel_id, @PathVariable("id") Long id, Model model) {
        HotelRoom hotelRoom = hotelRoomService.showOneHotelRoom(id);
        model.addAttribute("hotelRoom", hotelRoom);
        return "hotel/rooms/edit";
    }

    @PostMapping("/{hotel_id}/room/{id}/update")
    public String updateHotelRoom(@PathVariable("id") Long id, @ModelAttribute("hotelRoom") HotelRoom updatedHotelRoom) {
        hotelRoomService.updateHotelRoom(id, updatedHotelRoom);
        return "redirect:/hotel/{hotel_id}/room/" + id;
    }

    @GetMapping("/{hotel_id}/room/{id}/delete")
    public String deleteHotelRoom(@PathVariable("hotel_id") Long hotel_id, @PathVariable("id") Long id) {
        hotelRoomService.deleteHotelRoom(id);
        return "redirect:/hotel/{hotel_id}/room";
    }
}
