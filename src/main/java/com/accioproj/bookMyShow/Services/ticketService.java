package com.accioproj.bookMyShow.Services;

import com.accioproj.bookMyShow.Entity.*;
import com.accioproj.bookMyShow.Repositories.*;
import com.accioproj.bookMyShow.Requests.bookTicketRqst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    @Autowired
    private userRepo userRepo1;
    @Autowired
    private JavaMailSender mailSender;
    public String bookTicket(bookTicketRqst ticketDto)throws Exception
    {

        Optional<Show>optionalShow=showRepo1.findById(ticketDto.getShowId());
        if(optionalShow.isEmpty())
        {
            throw new Exception("Show not available for given movie at given time in given Theater Try changing  time OR Movie OR Theater");
        }
        Show show=optionalShow.get();
        Optional<User> optionalUser=userRepo1.findByEmailId(ticketDto.getUserMail());
        if(optionalUser.isEmpty())
        {
            throw new Exception("Email does not Exist");
        }
        User user=optionalUser.get();
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
                seat.setFoodAttached(ticketDto.isFoodAttached());
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
                .user(user)
                .build();
        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);
        ticketRepo1.save(ticket);

        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(user.getEmailId());
        msg.setFrom("pustakalay7120@gmail.com");
        msg.setSubject("Hello "+user.getName());
        msg.setText("Hey "+user.getName()+" Your tickets book Successfully for "+ticket.getMovieName()+" at "+
                ticket.getTheaterNameAndAdd()+". Your seats  are "+ticket.getSeats()+" Reach 10-20 Minutes prior to show. Your show Time is "+
                ticket.getShowTime()+" "+ticket.getShowDate()+". And  Amount  of Rs "+ticket.getAmtPaid()+" is already Paid");
        mailSender.send(msg);
        return "Ticket Successfully Booked";
    }
}
