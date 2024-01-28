package com.accioproj.bookMyShow.Services;

import com.accioproj.bookMyShow.Entity.*;
import com.accioproj.bookMyShow.Enums.seatType;
import com.accioproj.bookMyShow.Repositories.movieRepo;
import com.accioproj.bookMyShow.Repositories.showRepo;
import com.accioproj.bookMyShow.Repositories.showSeatRepo;
import com.accioproj.bookMyShow.Repositories.theaterRepo;
import com.accioproj.bookMyShow.Requests.addShowRqst;
import com.accioproj.bookMyShow.Requests.addShowSeatRqst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class showService {
    @Autowired
    private theaterRepo theaterRepo1;
    @Autowired
    private movieRepo movieRepo1;
    @Autowired
    private showRepo showRepo1;
    @Autowired
    private showSeatRepo showSeatRepo1;
    public String addShow(addShowRqst showDto)throws Exception
    {
        Optional<Theater> optionalTheater=theaterRepo1.findById(showDto.getTheaterId());
        if(optionalTheater.isEmpty())
        {
            throw new Exception("Theater ID dont Exist");
        }
        Theater theater=optionalTheater.get();
        Optional<Movie>optionalMovie=movieRepo1.findByMovieName(showDto.getMovieName());
        if(optionalMovie.isEmpty())
        {
            throw new Exception("Movie  Don't Exist");
        }
        Movie movie=optionalMovie.get();
        Show show =Show.builder()
                .showDate(showDto.getShowDate())
                .showTime(showDto.getShowTime())
                .movie(movie)
                .theater(theater)
                .build();
        movie.getShowList().add(show);
        theater.getShowList().add(show);
        showRepo1.save(show);

        return "Show Added Successfully with Timing of-- "+show.getShowTime()+" At-- "+theater.getTheaterName()+" For movie-- "+movie.getMovieName()+" on-- "+show.getShowDate();
    }
    public String addShowSeat(addShowSeatRqst showSeatDto) throws Exception
    {
        Optional<Show> optionalShow=showRepo1.findById(showSeatDto.getShowId());
        if(optionalShow.isEmpty())
        {
            throw new Exception("Show ID Dont Exist In System");
        }
        Show shows= optionalShow.get();
        List<ShowSeat>showSeatList=new ArrayList<>();
        Theater theater=shows.getTheater();
        List<TheaterSeat>theaterSeatList=theater.getTheaterSeatList();
        for(int i=0;i<theaterSeatList.size();i++)
        {
            TheaterSeat tSeat=theaterSeatList.get(i);
            if(tSeat.getSeattype().equals(seatType.PRIMIUM))
            {
                ShowSeat showS= ShowSeat.builder()
                .seatNo(tSeat.getSeatNo())
                .seattype(tSeat.getSeattype())
                .Available(Boolean.TRUE)
                        .price(200)
                .foodAttached(Boolean.FALSE)
                .seattype(seatType.PRIMIUM)
                .show(shows)
                .build();
                showSeatList.add(showS);
                showS=showSeatRepo1.save(showS);
                showSeatList.add(showS);
            }
            else
            {
                ShowSeat showS= ShowSeat.builder()
                        .seatNo(tSeat.getSeatNo())
                        .seattype(tSeat.getSeattype())
                        .Available(Boolean.TRUE)
                        .foodAttached(Boolean.FALSE)
                        .seattype(seatType.CLASSIC)
                        .price(100)
                        .show(shows)
                        .build();
                showSeatList.add(showS);
                //showS=showSeatRepo1.save(showS);
                showSeatList.add(showS);
            }
        }
        /*showSeat showS=showSeat.builder()
                .seatNo(theaterSeats.get(0).getSeatNo())
                .seattype(theaterSeats.get(0).getSeattype())
                .Available(Boolean.TRUE)
                .foodAttached(Boolean.FALSE)
                .seattype(seatType.PRIMIUM)
                .show(shows)
                .build();
        showSeatList.add(showS);*/
        shows.setShowSeatList(showSeatList);
        showRepo1.save(shows);
        return "Succefully Releases Seat  for  Show with ID-- "+shows.getShowId();
    }


}
