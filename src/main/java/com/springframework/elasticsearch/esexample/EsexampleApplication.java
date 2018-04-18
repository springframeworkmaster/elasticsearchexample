package com.springframework.elasticsearch.esexample;

import com.springframework.elasticsearch.esexample.domains.Movie;
import com.springframework.elasticsearch.esexample.services.MovieService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class EsexampleApplication implements CommandLineRunner {
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;
    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(EsexampleApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        printElasticSearchInfo();

        movieService.save(new Movie("1", "Baahubali", "Rajamouli", "06-21-2015"));
        movieService.save(new Movie("2", "avatar", "Thrivikram", "08-01-2009"));
        movieService.save(new Movie("3", "Avatar", "James Cameron", "04-26-2008"));
        movieService.save(new Movie("4", "Avatar", "Cameron", "09-28-2009"));

        Page<Movie> movies = movieService.findByDirector("Rajamouli", new PageRequest(0, 10));
        List<Movie> movies1 = movieService.findByMovieTitle("Avatar");

        movies.forEach(movie -> System.out.println(movie));
        movies1.forEach(movie -> System.out.println(movie));

    }

    private void printElasticSearchInfo(){

        System.out.println("ElasticSearch");
        Client client = elasticsearchOperations.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        asMap.forEach((k,v)-> {
            System.out.println(k + "=" + v);
        });
        System.out.println("ElasticSearch");
    }
}
