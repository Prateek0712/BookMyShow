package com.accioproj.bookMyShow.Entity;

import com.accioproj.bookMyShow.Enums.seatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theaterSeat")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class theaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    private Integer seatNo;
    @Enumerated(value = EnumType.STRING)
    private seatType seattype;

}
