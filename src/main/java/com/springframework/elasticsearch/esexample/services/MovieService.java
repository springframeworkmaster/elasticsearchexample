package com.springframework.elasticsearch.esexample.services;

import com.springframework.elasticsearch.esexample.domains.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie);
    void delete(Movie movie);
    Movie findOne(String id);
    Iterable<Movie> findAll();
    Page<Movie> findByDirector(String director, PageRequest pageRequest);
    List<Movie> findByMovieTitle(String movieTitle);
}
