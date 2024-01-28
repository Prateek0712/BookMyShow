package com.accioproj.bookMyShow.Services;

import com.accioproj.bookMyShow.Entity.*;
import com.accioproj.bookMyShow.Repositories.movieRepo;
import com.accioproj.bookMyShow.Repositories.showRepo;
import com.accioproj.bookMyShow.Repositories.theaterRepo;
import com.accioproj.bookMyShow.Repositories.ticketRepo;
import com.accioproj.bookMyShow.Requests.bookTicketRqst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ticketService {
    @Autowired
    private ticketRepo ticketRepo1;
    @Autowired
    private movieRepo movieRepo1;
    @Autowired
    private theaterRepo theaterRepo1;
    @Autowired
    private showRepo showRepo1;
    public String bookTicket(bookTicketRqst ticketDto)throws Exception
    {

        Optional<Show>optionalShow=showRepo1.findById(ticketDto.getShowId());
        if(optionalShow.isEmpty())
        {
            throw new Exception("Show not available for given movie at given time in given Theater Try changing  time OR Movie OR Theater");
        }
        Show show=optionalShow.get();
        //assign seats to  ticket
        List<ShowSeat>showSeatList=show.getShowSeatList();
        int totalAmt=0;
        //List<showSeat>bookedSeatAgainstTicket=new ArrayList<>();
        List<String> seatNumbers=ticketDto.getSeatNo();
        for(ShowSeat seat:showSeatList)
        {
            if(seatNumbers.contains(seat.getSeatNo()))
            {
                seat.setAvailable(Boolean.FALSE);
                //bookedSeatAgainstTicket.add(seat);
                totalAmt+=seat.getPrice();
            }
        }
        if(ticketDto.isFoodAttached())
        {
            totalAmt+=150;
        }
        //now create theater entity
        Ticket ticket=Ticket.builder()
                .AmtPaid(totalAmt)
                .movieName(show.getMovie().getMovieName())
                .theaterNameAndAdd(show.getTheater().getTheaterName()+" "+show.getTheater().getTheaterAddress())
                .seats(ticketDto.getSeatNo().toString())
                .showTime(show.getShowTime())
                .showDate(show.getShowDate())
                .show(show)
                .build();
        show.getTicketList().add(ticket);
        ticketRepo1.save(ticket);
        return "Ticket Successfully Booked";
    }
}
