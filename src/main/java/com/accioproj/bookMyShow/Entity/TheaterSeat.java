package com.accioproj.bookMyShow.Entity;

import com.accioproj.bookMyShow.Enums.seatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theaterSeat")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private seatType seattype;

    //Connecting to Theater as child
    @JoinColumn
    @ManyToOne
    private Theater theater;
}
