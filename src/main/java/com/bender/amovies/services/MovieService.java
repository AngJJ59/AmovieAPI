package com.bender.amovies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bender.amovies.MovieRepository;
import com.bender.amovies.model.Movie;

@Service
public class MovieService {
    @Autowired // no need instantiate object. autowired will recognize for us
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
