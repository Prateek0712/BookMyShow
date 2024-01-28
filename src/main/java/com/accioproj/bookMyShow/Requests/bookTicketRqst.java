package com.accioproj.bookMyShow.Requests;

import com.accioproj.bookMyShow.Enums.seatType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class bookTicketRqst {
    private Integer showId;
    private List<String> seatNo;
    private seatType seattype;
    private String userMail;
    private boolean foodAttached;
}
