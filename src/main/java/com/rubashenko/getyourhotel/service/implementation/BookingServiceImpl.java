package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Booking;
import com.rubashenko.getyourhotel.repository.BookingRepository;
import com.rubashenko.getyourhotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
