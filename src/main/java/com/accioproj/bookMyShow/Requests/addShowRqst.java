package com.accioproj.bookMyShow.Requests;

import com.accioproj.bookMyShow.Entity.Movie;
import com.accioproj.bookMyShow.Entity.Theater;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class addShowRqst {

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private Integer theaterId;
}
