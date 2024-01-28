package com.accioproj.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketID;
    private String seats;
    private Integer AmtPaid;
    private LocalTime showTime;
    private LocalDate showDate;
    private String movieName;
    private String theaterNameAndAdd;
    //connecting to show bidirectionally
    @JoinColumn
    @ManyToOne
    private Show show;

    //conttecting  to  user as child bidirectionally
    @JoinColumn
    @ManyToOne
    private User user;

}
