package com.accioproj.bookMyShow.Repositories;

import com.accioproj.bookMyShow.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ticketRepo extends JpaRepository<Ticket,Integer> {


}
