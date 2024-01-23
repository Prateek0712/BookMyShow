package com.accioproj.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketID;
    private Integer NoOfBookSeats;
    private Integer AmtPaid;

    //connecting to show bidirectionally
    @JoinColumn
    @ManyToOne
    private Show show;

}
