package com.accioproj.bookMyShow.Services;

import com.accioproj.bookMyShow.Entity.Movie;
import com.accioproj.bookMyShow.Repositories.movieRepo;
import com.accioproj.bookMyShow.Requests.addMovieRqst;
import com.accioproj.bookMyShow.Transformers.addMovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class movieService {
    @Autowired
    private movieRepo movieRepo;

    public String addMovie(addMovieRqst movieDto)
    {
        Movie movie= addMovieTransformer.convertAddMovieRqsttoMovie(movieDto);
        movieRepo.save(movie);
        return "Movie add Successfully with ID-- "+movie.getMovieId();
    }
}
