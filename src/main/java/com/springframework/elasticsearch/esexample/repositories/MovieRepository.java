package com.springframework.elasticsearch.esexample.repositories;

import com.springframework.elasticsearch.esexample.domains.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface MovieRepository extends ElasticsearchRepository<Movie, String> {
   Page<Movie> findByDirector(String director, org.springframework.data.domain.Pageable pageable);
   List<Movie> findByMovieTitle(String movieTitle);
}
