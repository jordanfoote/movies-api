package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private List<Movie> movies = setMovies();

    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("all")
    public List<Movie> getMovies() {
        return moviesRepository.findAll();
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        return moviesRepository.findById(id).orElse(null);
    }

    @GetMapping("search")
    public List<Movie> getByTitle(@RequestParam("title") String title) {
        return moviesRepository.findByTitle(title);
    }

    @GetMapping("search/year")
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear) {
        return moviesRepository.findByYearRange(startYear, endYear);
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        moviesRepository.save(movie);
    }

    @PostMapping("many")
    public void createMany(@RequestBody List<Movie> movies) {
        moviesRepository.saveAll(movies);
    }

    private List<Movie> setMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1, "Gladiator", "2000","A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery."));
        movies.add(new Movie(2, "The Perfect Storm", "2000","An unusually intense storm pattern catches some commercial fishermen unaware and puts them in mortal danger."));
        movies.add(new Movie(3, "Superbad", "2007","Two co-dependent high school seniors are forced to deal with separation anxiety after their plan to stage a booze-soaked party goes awry."));

        return movies;
    }
}
