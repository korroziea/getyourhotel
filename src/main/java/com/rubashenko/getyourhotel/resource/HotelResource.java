package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Hotels;
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
    public String newHotel(@ModelAttribute("hotel") Hotels hotel) {
        return "hotel/new";
    }

    @PostMapping("/create")
    public String saveHotel(@ModelAttribute("hotel") Hotels hotel) {
        Hotels hotelDTO = hotelService.createHotel(hotel);
        return "hello"; // check
    }

    @GetMapping()
    public String showHotels(Model model) {
        List<Hotels> hotels = hotelService.showAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotel/showAll";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("hotel", hotelService.findHotel(id));
//        return "hotel/show";
//    }
}
