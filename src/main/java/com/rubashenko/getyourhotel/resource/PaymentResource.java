package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Payment;
import com.rubashenko.getyourhotel.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping(path = "/hotel/{hotel_id}/room/{room_id}/booking/{booking_id}/payment")
@RequiredArgsConstructor
public class PaymentResource {
    private final PaymentService paymentService;

    @GetMapping("/new")
    public String newPayment(@PathVariable("hotel_id") Long hotel_id, @PathVariable("room_id") Long room_id,
                             @PathVariable("booking_id") Long booking_id, @ModelAttribute("payment") Payment payment) {
        return "hotel/rooms/payment/new";
    }

    @PostMapping("/create")
    public String savePayment(@PathVariable("hotel_id") Long hotel_id, @PathVariable("room_id") Long room_id,
                              @PathVariable("booking_id") Long booking_id, @ModelAttribute("payment") Payment payment, Model model) {
        payment.setUser_id(9L);
        payment.setBooking_id(booking_id);
        payment.setCreated_at(LocalDateTime.now());
        paymentService.createPayment(payment);
        model.addAttribute("hotel_id", hotel_id);
        model.addAttribute("room_id", room_id);
        model.addAttribute("booking_id", booking_id);
        return "redirect:/hotel";
    }
}
