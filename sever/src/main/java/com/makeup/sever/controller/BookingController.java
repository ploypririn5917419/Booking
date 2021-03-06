package com.makeup.sever.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;
import com.makeup.sever.entity.*;
import com.makeup.sever.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private StyleRepository styleRepository;
    @Autowired
    private PositionRepository positionRepository;

    public BookingController(BookingRepository bookingRepository, CustomerRepository customerRepository, StaffRepository staffRepository, StyleRepository styleRepository, PositionRepository positionRepository) {
        this.bookingRepository = bookingRepository;
        this.positionRepository = positionRepository;
        this.staffRepository = staffRepository;
        this.customerRepository = customerRepository;
        this.styleRepository = styleRepository;
    }

    @RequestMapping("/booking")
    public Collection<Booking> booking() {
        return bookingRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/makeupBooking/{styleID}/{styleIDs}/{styleName}/{stylePrice}/{stID}/{staffIDs}/{staffName}/{bookingDate}/{cusId}/{customerIDs}/{customerName}/{addressCustomer}")
    public Booking newMakeupBooking(@PathVariable Long cusId,@PathVariable String customerIDs,
                                    @PathVariable String customerName, @PathVariable String addressCustomer,
                                    @PathVariable Long stID, @PathVariable String staffIDs,
                                    @PathVariable String staffName, @PathVariable String bookingDate,
                                    @PathVariable Long styleID, @PathVariable String styleIDs,
                                    @PathVariable String styleName, @PathVariable int stylePrice) {

        Booking newBooking = new Booking();

        String sDate1 = bookingDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        LocalDate date = LocalDate.parse(sDate1, formatter);
        newBooking.setBookingDate(date);

        Customer customer0 = customerRepository.findByCusId(cusId);
        newBooking.setCustomer(customer0);

        Staff staff0 = staffRepository.findBystID(stID);
        newBooking.setStaff(staff0);

        Style    style0 =  styleRepository.findBystyleID(styleID);
        newBooking.setStyle(style0);

        return bookingRepository.save(newBooking);
    }
}
