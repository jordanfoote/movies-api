package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/movies")
public class MoviesController {

    @GetMapping("all")
    public List<Movie> getAll(){
        return new ArrayList<>();
    }



}
