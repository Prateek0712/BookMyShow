package com.accioproj.bookMyShow.Requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class addTheaterSeatRqst {
    private Integer noOfPrimiumSeat;
    private Integer noOfClassicSeat;
    private Integer noOfCol;
    private Integer theaterId;
}
