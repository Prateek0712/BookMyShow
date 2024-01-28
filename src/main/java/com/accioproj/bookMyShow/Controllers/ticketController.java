package com.accioproj.bookMyShow.Controllers;

import com.accioproj.bookMyShow.Requests.bookTicketRqst;
import com.accioproj.bookMyShow.Services.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class ticketController {
    @Autowired
    private ticketService ticketService1;

    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody bookTicketRqst ticketDto)
    {
        try {
            String resp= ticketService1.bookTicket(ticketDto);
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        }
        catch(Exception e)
        {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
