package com.accioproj.bookMyShow.Controllers;

import com.accioproj.bookMyShow.Requests.addMovieRqst;
import com.accioproj.bookMyShow.Services.movieService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class movieController {
    @Autowired
    private movieService movieService;
    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody addMovieRqst movieDto)
    {
        String resp= movieService.addMovie(movieDto);
        return  new ResponseEntity<>(resp, HttpStatus.CREATED);
    }
}
