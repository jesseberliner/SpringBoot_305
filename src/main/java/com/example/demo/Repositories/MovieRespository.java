package com.example.demo.Repositories;

import com.example.demo.Models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRespository extends CrudRepository<Movie, Long> {
}
