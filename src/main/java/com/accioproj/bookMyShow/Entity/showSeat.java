package com.accioproj.bookMyShow.Entity;

import com.accioproj.bookMyShow.Enums.seatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "showSeat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class showSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private Integer price;
    private Boolean Available;
    private Boolean foodAttached;
    private Integer seatNo;
    private seatType seattype;

}
