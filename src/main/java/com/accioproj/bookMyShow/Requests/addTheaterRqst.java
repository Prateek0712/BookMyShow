package com.accioproj.bookMyShow.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addTheaterRqst {
    private String theaterName;
    private String theaterAddress;
    private Integer noOfScreen;
}
