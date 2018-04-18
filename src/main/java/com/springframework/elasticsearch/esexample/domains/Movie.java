package com.springframework.elasticsearch.esexample.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "krish", type = "movies")
public class Movie {

    @Id
    private String id;
    private String movieTitle;
    private String director;
    private String releaseDate;

    public Movie(){}

    public Movie(String id, String movieTitle, String director, String releaseDate) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
