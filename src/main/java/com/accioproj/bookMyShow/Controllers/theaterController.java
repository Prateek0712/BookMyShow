package com.accioproj.bookMyShow.Controllers;

import com.accioproj.bookMyShow.Requests.addTheaterRqst;
import com.accioproj.bookMyShow.Requests.addTheaterSeatRqst;
import com.accioproj.bookMyShow.Services.theaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Theater")
public class theaterController {
    @Autowired
    private theaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity addTheater(addTheaterRqst theaterDto)
    {
        String Resp= theaterService.addTheater(theaterDto);
        return new ResponseEntity<>(Resp, HttpStatus.CREATED);
    }
    @PostMapping("/addTheaterSeat")
    public ResponseEntity addTheaterSeat (addTheaterSeatRqst theaterSeatDto)
    {
        String resp=theaterService.addTheaterSeats(theaterSeatDto);
        return new ResponseEntity(resp,HttpStatus.CREATED);
    }
}
