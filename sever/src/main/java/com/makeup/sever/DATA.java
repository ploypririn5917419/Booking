package com.makeup.sever;
import com.makeup.sever.entity.*;
import com.makeup.sever.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.CharacterEncodingFilter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DATA {
    Date date = new Date();
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DATA.class, args);
    }
    public DATA(BookingRepository bookingRepository,
                CustomerRepository customerRepository,
                StaffRepository staffRepository,
                PositionRepository positionRepository,
                StyleRepository styleRepository){
    }
    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    ApplicationRunner init(BookingRepository bookingRepository,
                           CustomerRepository customerRepository,
                           StaffRepository staffRepository,
                           PositionRepository positionRepository,
                           StyleRepository styleRepository) {
        return args -> {
            Stream.of("Sunvo", "Ploy", "Ao" ,"Wahn","Opal","Meen").forEach(cusName -> {

                Customer customerdb = new Customer();
                customerdb.setCustomerName(cusName);
                customerRepository.save(customerdb);

                if (cusName == "Sunvo") {
                    Customer cusid = customerRepository.findByCusId(1L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setGender("Male");
                    customerdb.setAddressCustomer("Korat");
                    customerRepository.save(customerdb);

                }
                else if(cusName == "Ploy"){
                    Customer cusid = customerRepository.findByCusId(2L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setGender("Female");
                    customerdb.setAddressCustomer("Suranaree");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Ao"){
                    Customer cusid = customerRepository.findByCusId(3L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setGender("Male");
                    customerdb.setAddressCustomer("Sungneon");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Wahn"){
                    Customer cusid = customerRepository.findByCusId(4L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setGender("Female");
                    customerdb.setAddressCustomer("Krathok");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Opal"){
                    Customer cusid = customerRepository.findByCusId(5L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setGender("Female");
                    customerdb.setAddressCustomer("Khonkan");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Meen"){
                    Customer cusid = customerRepository.findByCusId(6L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setGender("Female");
                    customerdb.setAddressCustomer("Korat");
                    customerRepository.save(customerdb);
                }
            });
            Customer c1 = customerRepository.findByCusId(1L);
            Customer c2 = customerRepository.findByCusId(2L);
            Customer c3 = customerRepository.findByCusId(3L);
            Customer c4 = customerRepository.findByCusId(4L);
            Customer c5 = customerRepository.findByCusId(5L);
            Customer c6 = customerRepository.findByCusId(6L);

            Stream.of("korea style", "thai style", "laos style","wedding", "thai wedding", "chinese style").forEach(styName -> {
                Style styledb = new Style();
                styledb.setStyleName(styName);
                styleRepository.save(styledb);

                if (styName == "korea style") {
                    Style styleID = styleRepository.findBystyleID(1L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(3000);
                    styleRepository.save(styledb);
                }
                else if(styName == "thai style"){
                    Style styleID = styleRepository.findBystyleID(2L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(2000);
                    styleRepository.save(styledb);
                }
                else if(styName == "laos style"){
                    Style styleID = styleRepository.findBystyleID(3L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(1700);
                    styleRepository.save(styledb);
                }
                else if(styName == "wedding"){
                    Style styleID = styleRepository.findBystyleID(4L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(5000);
                    styleRepository.save(styledb);
                }
                else if(styName == "thai wedding"){
                    Style styleID = styleRepository.findBystyleID(5L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(4500);
                    styleRepository.save(styledb);
                }
                else if(styName == "chinese style"){
                    Style styleID = styleRepository.findBystyleID(6L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(2500);
                    styleRepository.save(styledb);
                }
            });
            Style sy1 = styleRepository.findBystyleID(1L);
            Style sy2 = styleRepository.findBystyleID(2L);
            Style sy3 = styleRepository.findBystyleID(3L);
            Style sy4 = styleRepository.findBystyleID(4L);
            Style sy5 = styleRepository.findBystyleID(5L);
            Style sy6 = styleRepository.findBystyleID(6L);

            Stream.of("HairStylist", "MakeupArtist").forEach(posName -> {
                Position positiondb = new Position();
                positiondb.setPositionName(posName);
                positionRepository.save(positiondb);

                if (posName == "HairStylist") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }
                else if(posName == "MakeupArtist") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }
            });

            Position p1 = positionRepository.findBypositionId(1L);
            Position p2 = positionRepository.findBypositionId(2L);

            Stream.of("Somsri", "Somsak", "Somjit","Prayut","Pranee").forEach(stName -> {
                Staff staffdb = new Staff();
                staffdb.setStaffName(stName);
                staffRepository.save(staffdb);

                if (stName == "Somsri") {
                    staffdb.setStaffIDs("St"+staffdb.getStID());
                    staffdb.setStaffName(stName);
                    staffdb.setPosition(p2);
                    staffRepository.save(staffdb);
                }
                else if(stName == "Somsak"){
                    staffdb.setStaffIDs("St"+staffdb.getStID());
                    staffdb.setStaffName(stName);
                    staffdb.setPosition(p1);
                    staffRepository.save(staffdb);
                }
                else if(stName == "Prayut"){
                    staffdb.setStaffIDs("St"+staffdb.getStID());
                    staffdb.setStaffName(stName);
                    staffdb.setPosition(p1);
                    staffRepository.save(staffdb);
                }
                else if(stName == "Pranee"){
                    staffdb.setStaffIDs("St"+staffdb.getStID());
                    staffdb.setStaffName(stName);
                    staffdb.setPosition(p1);
                    staffRepository.save(staffdb);
                }
                else if(stName == "Somjit"){
                    staffdb.setStaffIDs("St"+staffdb.getStID());
                    staffdb.setStaffName(stName);
                    staffdb.setPosition(p2);
                    staffRepository.save(staffdb);
                }
            });

            Staff st1 = staffRepository.findBystID(1L);
            Staff st2 = staffRepository.findBystID(2L);
            Staff st3 = staffRepository.findBystID(3L);
            Staff st4 = staffRepository.findBystID(4L);
            Staff st5 = staffRepository.findBystID(5L);

            Booking bookingdb = new Booking();
            String sDate1 = "20:04:1998";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate date = LocalDate.parse(sDate1, formatter);
            bookingRepository.save(bookingdb);

            bookingdb.setBookingDate(date);
            bookingdb.setCustomer(c1);
            bookingdb.setStaff(st1);
            bookingdb.setStyle(sy1);
            bookingRepository.save(bookingdb);

            System.out.println("\n Spring-Boot Complete");
        };
    }
}