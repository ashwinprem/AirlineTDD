package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class FlightController {

	private final FlightService flightService;
	private final BookingService bookingService;

	public FlightController(FlightService flightService, BookingService bookingService) {
		this.flightService = flightService;
		this.bookingService = bookingService;
	}

	@GetMapping("/flights")
	public String listFlights(Model model) {
		model.addAttribute("flights", flightService.findAllFlights());
		return "flights"; // This should point to a Thymeleaf template named "flights.html"
	}

	@GetMapping("/book")
	public String showBookingForm(@RequestParam("flightId") Long flightId, Model model) {
		Optional<Flight> flightOptional = flightService.findFlightById(flightId);

		if (!flightOptional.isPresent()) {
			model.addAttribute("errorMessage", "Flight not found");
			return "errorPage"; // Redirect or display an error message appropriately
		}

		model.addAttribute("bookingForm", new BookingForm());
		model.addAttribute("flight", flightOptional.get());
		return "book";
	}



	@PostMapping("/book")
	public String processBooking(BookingForm bookingForm, Model model) {
		List<Flight> flights = bookingForm.getFlightIds().stream()
				.map(flightService::findFlightById)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());

		List<Passenger> passengers = bookingForm.getPassengerNames().stream() // assuming getPassengerDetails returns details including age
				.map(detail -> new Passenger(detail.getName(), detail.getAge())) // create Passenger with name and age
				.collect(Collectors.toList());

		// Assuming createBooking takes these lists directly. Adapt parameters as needed.
		Booking newBooking = bookingService.createBooking(
				bookingForm.getBookingNumber(),
				flights,
				passengers,
				bookingForm.isRoundTrip(),
				bookingForm.isDirectFlight(),
				bookingForm.getUserTimezone()
		);

		model.addAttribute("message", "Booking successful with ID: " + newBooking.getId());
		return "redirect:/flights";
	}

}
