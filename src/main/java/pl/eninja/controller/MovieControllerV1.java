package pl.eninja.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.eninja.domain.Movie;
import pl.eninja.service.MovieServiceV1;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieControllerV1 {

  private final MovieServiceV1 movieServiceV1;

  @Autowired
  public MovieControllerV1(MovieServiceV1 movieServiceV1) {
    this.movieServiceV1 = movieServiceV1;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Movie> getAllMovies() {
    return movieServiceV1.getAllMovies();
  }

  @GetMapping(path = "/id={id}",
              produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Movie getMovieById(@PathVariable("id") Long movieId) throws NotFoundException {
    return movieServiceV1.getMovieById(movieId);
  }

  @GetMapping(path = "/t={title}",
              produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Movie> getMovieByTitle(@PathVariable("title") String title) {
    return movieServiceV1.getMoviesByTitle(title);
  }

  @GetMapping(path = ("/count"),
              produces = MediaType.APPLICATION_JSON_VALUE)
  public String countMovies() {
    return movieServiceV1.countMovies();
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
               consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addMovie(@RequestBody Movie movie) {
    movieServiceV1.addMovie(movie);
  }

  @PutMapping(path = ("/id={id}"),
              consumes = MediaType.APPLICATION_JSON_VALUE,
              produces = MediaType.APPLICATION_JSON_VALUE)
  public void updateMovie(
          @PathVariable("id") Long movieId, @RequestBody Movie movie) throws NotFoundException {
    movieServiceV1.updateMovie(movieId, movie);
  }
}