package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Hotel;
import com.rubashenko.getyourhotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("hotel", hotelService.findHotel(id));
//        return "hotel/show";
//    }
}
