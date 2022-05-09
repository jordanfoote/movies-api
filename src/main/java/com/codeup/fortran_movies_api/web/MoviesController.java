package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private List<Movie> sampleMovies = setMovies();

    @GetMapping
    public Movie one() {
        return sampleMovies.get(1);
    }

    @GetMapping("all")
    public List<Movie> getAll(){
        return sampleMovies;
    }


    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        return sampleMovies.stream().filter((movie) -> {
            return movie.getId() == id;
        })
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        sampleMovies.add(movie);
    }

    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesToAdd) {
        sampleMovies.addAll(moviesToAdd);
    }

    private List<Movie> setMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1, "Gladiator", "2000", "Ridley Scott", "Russell Crowe, Joaquin Phoenix, Connie Nielsen","Action, Adventure, Drama", "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery."));
        movies.add(new Movie(2, "The Perfect Storm", "2000", "Wolfgang Petersen", "George Clooney, Mark Wahlberg, John C. Reilly","Action, Adventure, Drama", "An unusually intense storm pattern catches some commercial fishermen unaware and puts them in mortal danger."));
        movies.add(new Movie(3, "Superbad", "2007", "Greg Mottola", "Michael Cera, Jonah Hill, Christopher Mintz-Plasse","Comedy", "Two co-dependent high school seniors are forced to deal with separation anxiety after their plan to stage a booze-soaked party goes awry."));

        return movies;
    }
}
