package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Hotel;
import com.rubashenko.getyourhotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/hotel")
@RequiredArgsConstructor
public class HotelResource {
    private final HotelService hotelService;

    @GetMapping("/new")
    public String newHotel(@ModelAttribute("hotel") Hotel hotel) {
        return "hotel/new";
    }

    @PostMapping("/create")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel) {
        Hotel hotelDTO = hotelService.createHotel(hotel);
        return "hello"; // check
    }

    @GetMapping()
    public String showHotels(Model model) {
        List<Hotel> hotels = hotelService.showAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotel/showAll";
    }

    @GetMapping("/{id}")
    public String showHotel(@PathVariable("id") Long id, Model model) {
        Hotel hotel = hotelService.showOneHotel(id);
        model.addAttribute("hotel", hotel);
        return "hotel/showOne";
    }

    @GetMapping("/{id}/edit")
    public String editHotelForm(@PathVariable("id") Long id, Model model) {
        Hotel hotel = hotelService.showOneHotel(id);
        model.addAttribute("hotel", hotel);
        return "hotel/edit";
    }

    @PostMapping("/{id}/update")
    public String updateHotel(@PathVariable("id") Long id, @ModelAttribute("hotel") Hotel updatedHotel) {
        hotelService.updateHotel(id, updatedHotel);
        return "redirect:/hotel/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteHotel(@PathVariable("id") Long id) {
        hotelService.deleteHotel(id);
        return "redirect:/hotel";
    }
}
