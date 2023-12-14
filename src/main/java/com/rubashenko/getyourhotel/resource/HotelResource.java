package com.rubashenko.getyourhotel.resource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.rubashenko.getyourhotel.domain.Hotel;
import com.rubashenko.getyourhotel.domain.HotelRoom;
import com.rubashenko.getyourhotel.service.HotelRoomService;
import com.rubashenko.getyourhotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        return "redirect:hotel/show";
    }

    @GetMapping()
    public String showHotels(Model model) {
        List<Hotel> hotels = hotelService.showAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotel/showAll";
    }

    @GetMapping("/search/{title}")
    public String searchHotelByTitle(@PathVariable("title") String title, Model model) {
        Hotel hotel = hotelService.findHotelByTitle(title);
        Long id = hotel.getId();
        model.addAttribute("hotel", hotel);
        return "redirect:/hotel/" + id;
    }

    @GetMapping("/{id}")
    public String searchHotelById(@PathVariable("id") Long id, Model model, @ModelAttribute("hotelRoom") HotelRoom hotelRoom) {
        Hotel hotel = hotelService.showOneHotel(id);
        hotelRoom.setHotel_id(id);
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

    @GetMapping("/report")
    public String createReport() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("order.pdf"));
            document.open();

            List<Hotel> hotels = hotelService.showAllHotels();
            for (Hotel hotel : hotels) {
                document.add(new Paragraph(hotel.getTitle()));
                document.add(new Paragraph(String.valueOf(hotel.getRating())));
                document.add(new Paragraph(hotel.getCountry()));
                document.add(new Paragraph(hotel.getCity()));
                document.add(new Paragraph());
            }

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/hotel";
    }
}
