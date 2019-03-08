package com.example.demo.Controllers;

import com.example.demo.Models.Actor;
import com.example.demo.Models.Movie;
import com.example.demo.Repositories.ActorRepository;
import com.example.demo.Repositories.MovieRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRespository movieRespository;

    @RequestMapping("/")
    public String index(Model model)
    {
        //create an actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

        //create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        //Add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //Add the list of movies to the actor's movie list
        actor.setMovies(movies);

        //Save the actor to the database
        actorRepository.save(actor);

        //Grab all the actors from the database and send them to the template
        model.addAttribute("actors", actorRepository.findAll());

        return "index";
    }
}
