package com.accioproj.bookMyShow.Entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/*@Entity
@Table(name = "shows")
@Data
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalDate showDate;

    private LocalTime showTime;

    @JoinColumn
    @ManyToOne
    private Movie movie;


    @JoinColumn
    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<showSeat> showSeatList = new ArrayList<>();

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

}*/
@Entity
@Table(name = "shows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    //connecting  to  theater as child
    @JoinColumn
    @ManyToOne
    private Theater theater;

    //connecting to theater seat as Parent
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<ShowSeat>showSeatList=new ArrayList<>();

    //connecting to ticket as a parent
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<Ticket>ticketList=new ArrayList<>();



}
