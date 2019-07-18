package com.springframework.elasticsearch.esexample.services;

import com.springframework.elasticsearch.esexample.domains.Movie;
import com.springframework.elasticsearch.esexample.repositories.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Movie movie) {
       movieRepository.delete(movie);
    }

    @Override
    public Movie findOne(String id) {
        return movieRepository.findOne(id);
    }

    @Override
    public Iterable<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll()
            .iterator()
            .forEachRemaining(movie -> movies.add(movie));
        return movies;
    }

    @Override
    public Page<Movie> findByDirector(String director, PageRequest pageRequest) {
        return movieRepository.findByDirector(director,pageRequest);
    }

    @Override
    public List<Movie> findByMovieTitle(String movieTitle) {
        return movieRepository.findByMovieTitle(movieTitle);
    }
}
