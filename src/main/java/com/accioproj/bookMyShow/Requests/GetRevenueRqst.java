package com.accioproj.bookMyShow.Requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetRevenueRqst {
    String theaterName;
    String theaterAdd;
    String movieName;
}
