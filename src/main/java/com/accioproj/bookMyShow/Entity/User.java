package com.accioproj.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(nullable = false,unique = true)
    private Integer phoneNo;
    private String name;
    @Column(nullable = false,unique = true)
    private String emailId;

    //CONNECTING TO Ticket as parent
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Ticket>ticketList=new ArrayList<>();
}
