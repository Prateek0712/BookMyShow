package com.accioproj.bookMyShow.Controllers;

import com.accioproj.bookMyShow.Repositories.showSeatRepo;
import com.accioproj.bookMyShow.Requests.addShowRqst;
import com.accioproj.bookMyShow.Requests.addShowSeatRqst;
import com.accioproj.bookMyShow.Services.showService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class showController {
    @Autowired
    private showService showservice;
    @Autowired
    private showSeatRepo showSeatRepo1;
    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody addShowRqst showDto)
    {
        try
        {
            String resp = showservice.addShow(showDto);
            return new ResponseEntity<>(resp, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/setShowSeat")
    public ResponseEntity addShowSeat(@RequestBody addShowSeatRqst showSeatDto)
    {
        try
        {
            String resp=showservice.addShowSeat(showSeatDto);
            return new ResponseEntity<>(resp,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
