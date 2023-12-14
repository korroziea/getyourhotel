package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Booking;
import com.rubashenko.getyourhotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping(path = "/hotel")
@RequiredArgsConstructor
public class BookingResource {
    private final BookingService bookingService;

    @GetMapping("/{hotel_id}/room/{room_id}/booking/new")
    public String newBooking(@PathVariable("hotel_id") Long hotel_id, @PathVariable("room_id") Long room_id, @ModelAttribute("booking") Booking booking) {
        return "hotel/rooms/booking/new";
    }

    @PostMapping("/{hotel_id}/room/{room_id}/booking/create")
    public String saveBooking(@PathVariable("hotel_id") Long hotel_id, @PathVariable("room_id") Long room_id, @ModelAttribute("booking") Booking booking, Model model) {
        booking.setUser_id(9L);
        booking.setHotelroom_id(room_id);
        booking.setCreated_at(LocalDateTime.now());
        bookingService.createBooking(booking);
        Long booking_id = booking.getId();
        model.addAttribute("hotel_id", hotel_id);
        model.addAttribute("room_id", room_id);
        return "redirect:" + booking_id + "/payment/new";
    }


}