package com.accioproj.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theater")
@NoArgsConstructor
@AllArgsConstructor
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


}
