package com.accioproj.bookMyShow.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addUserRqst {
    private String name;
    private Integer phoneNo;
    private String email;
}
