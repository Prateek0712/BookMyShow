package com.accioproj.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    @Column(unique = true)
    private String theaterName;
    private String theaterAddress;
    private Integer noOfScreen;

    //connecting to theaterSeat as parent
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeat> theaterSeatList=new ArrayList<>();

    //connecting  to show as parent
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<Show>showList=new ArrayList<>();

}
