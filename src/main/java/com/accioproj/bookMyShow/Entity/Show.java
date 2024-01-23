package com.accioproj.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "show")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalDate showDate;
    private LocalTime showTime;

    //connecting  to  movie birectionally as child
    @JoinColumn
    @ManyToOne
    private Movie movie;

    //connecting to ticket as a parent
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL);
    List<Ticket>ticketList=new ArrayList<>();

    //connecting  to  theater as child
    @JoinColumn
    @ManyToOne
    private Theater theater;

    //connecting to theater seat as Parent
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<showSeat>showSeatList=new ArrayList<>();

}
