package com.accioproj.bookMyShow.Services;

import com.accioproj.bookMyShow.Entity.Show;
import com.accioproj.bookMyShow.Entity.ShowSeat;
import com.accioproj.bookMyShow.Entity.Theater;
import com.accioproj.bookMyShow.Entity.TheaterSeat;
import com.accioproj.bookMyShow.Enums.seatType;
import com.accioproj.bookMyShow.Repositories.theaterRepo;
import com.accioproj.bookMyShow.Requests.GetRevenueRqst;
import com.accioproj.bookMyShow.Requests.addTheaterRqst;
import com.accioproj.bookMyShow.Requests.addTheaterSeatRqst;
import com.accioproj.bookMyShow.Transformers.addTheaterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class theaterService {
    @Autowired
    private theaterRepo theaterRepo;

    public String  addTheater(addTheaterRqst theaterDto)
    {
        Theater theater= addTheaterTransformer.convertAddTheaterRqstToTheater(theaterDto);
        theaterRepo.save(theater);
        return "Theater Added Successfully with ID-- "+theater.getTheaterId();
    }
    public void addseatHelper(Integer noOfSeat, seatType seatType, Integer col, List<TheaterSeat>theaterSeatList, Theater theater)
    {
        int div=noOfSeat/col;
        int rem=noOfSeat%col;
        for(char ch='A';ch<'A'+div;ch++ )
        {
            for(int i=1;i<=col;i++)
            {
                String seatno= ch+""+i+""+ seatType.toString().charAt(0);
                TheaterSeat tSeat= TheaterSeat.builder()
                        .seatNo(seatno)
                        .seattype(seatType)
                        .theater(theater) //set  parent  in child class
                        .build();
                theaterSeatList.add(tSeat);
            }
        }
        char chR= (char) ('A'+div);
        for(int  i=1;i<=rem;i++)
        {
            String seatno= chR+""+i+""+ seatType.toString().charAt(0);
            TheaterSeat tSeat= TheaterSeat.builder()
                    .seatNo(seatno)
                    .seattype(seatType)
                    .theater(theater)
                    .build();
            theaterSeatList.add(tSeat);
        }
    }
    public String addTheaterSeats(addTheaterSeatRqst theaterSeatDto)
    {
        List<TheaterSeat> theaterSeatList=new ArrayList<>();
        int col=theaterSeatDto.getNoOfCol();
        int noOfPremium=theaterSeatDto.getNoOfPrimiumSeat();
        int noOfClassic=theaterSeatDto.getNoOfClassicSeat();
        seatType Pseattype=seatType.PRIMIUM;
        seatType CseatType=seatType.CLASSIC;
        Theater theater= theaterRepo.findById(theaterSeatDto.getTheaterId()).get();
        addseatHelper(noOfPremium,Pseattype,col,theaterSeatList,theater);
        addseatHelper(noOfClassic,CseatType,col,theaterSeatList,theater);
        //set child class attibute in parent  class
        theater.setTheaterSeatList(theaterSeatList);
        theaterRepo.save(theater);
        return "Theater Seats Added Succesfully";
    }
    public Integer GetRevenue(GetRevenueRqst revenueRqst) throws Exception
    {
        Optional<Theater> optionalTheater=theaterRepo.findByTheaterNameAndTheaterAddress(revenueRqst.getTheaterName(), revenueRqst.getTheaterAdd());
        if(optionalTheater.isEmpty()) {
            throw new Exception("TheaterNotfound");
        }
        Theater theater=optionalTheater.get();
        List<Show>showList=theater.getShowList();
        for(Show s:showList)
        {
            if(s.getMovie().getMovieName().equals(revenueRqst.getMovieName()))
            {
                continue;
            }
            showList.remove(s);
        }
        if(showList.isEmpty())
        {
            throw new Exception("No movie with  given name is available at this theater");
        }
        int  revenue=0;
        for(Show s: showList)
        {
            for(ShowSeat ss: s.getShowSeatList())
            {
                if(ss.getAvailable().equals(Boolean.FALSE))
                {
                    revenue+=ss.getPrice();
                }
            }
        }
        return revenue;

    }
}
