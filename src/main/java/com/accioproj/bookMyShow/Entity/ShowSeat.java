package com.accioproj.bookMyShow.Entity;

import com.accioproj.bookMyShow.Enums.seatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "showSeat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private Integer price;
    private Boolean Available;
    private Boolean foodAttached;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private seatType seattype;

    //connecting to  show as child
    @JoinColumn
    @ManyToOne
    private Show show;

}
