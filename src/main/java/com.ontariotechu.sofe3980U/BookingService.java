package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // Creates a new booking and adds it to the list
    public Booking createBooking(String bookingNumber, List<Flight> flights, List<Passenger> passengers, boolean isRoundTrip, boolean isDirectFlight, ZoneId userTimezone) {
        Booking newBooking = new Booking(bookingNumber, flights, passengers, isRoundTrip, isDirectFlight, userTimezone);
        // For simplicity, use a simple counter to simulate generating unique IDs
        newBooking.setId(counter.incrementAndGet()); // Assuming Booking class has an id field
        bookings.add(newBooking);
        return newBooking;
    }

    // Retrieves all bookings
    public List<Booking> findAllBookings() {
        return new ArrayList<>(bookings);
    }

    // Finds a booking by its ID
    public Optional<Booking> findBookingById(Long id) {
        return bookings.stream().filter(booking -> booking.getId().equals(id)).findFirst();
    }


    // Additional methods for updating or deleting bookings can be added here as needed
}
