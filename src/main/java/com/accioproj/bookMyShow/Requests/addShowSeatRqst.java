package com.accioproj.bookMyShow.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class addShowSeatRqst {
    private Integer showId;
    private Integer priceOfPrimium;
    private Integer priceOfClassic;
}
