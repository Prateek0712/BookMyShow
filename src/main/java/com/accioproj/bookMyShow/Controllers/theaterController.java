package com.accioproj.bookMyShow.Controllers;

import com.accioproj.bookMyShow.Requests.GetRevenueRqst;
import com.accioproj.bookMyShow.Requests.addTheaterRqst;
import com.accioproj.bookMyShow.Requests.addTheaterSeatRqst;
import com.accioproj.bookMyShow.Services.theaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/CalculateRevenue")
    public ResponseEntity GetRevenueForMovie(@RequestBody GetRevenueRqst revenueRqst)
    {
        try{
            Integer resp=theaterService.GetRevenue(revenueRqst);
            return new ResponseEntity(resp,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
