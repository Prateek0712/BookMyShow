package com.accioproj.bookMyShow.Entity;

import com.accioproj.bookMyShow.Enums.Genre;
import com.accioproj.bookMyShow.Enums.Languege;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //Entity anotation requires noArgsConstructor
@Table(name = "movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;

    @Enumerated(value = EnumType.STRING)
    private Languege movieLanguege;

    @Enumerated(value = EnumType.STRING)
    private Genre movieGenre;

    private String director;

    private LocalDate releaseDate;
    private Integer Duration;

    //connection  to show bidirectionlly
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<Show> showList=new ArrayList<>();

}
