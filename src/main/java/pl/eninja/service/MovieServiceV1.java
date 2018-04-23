package pl.eninja.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.eninja.domain.Movie;
import pl.eninja.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceV1 {
  private final MovieRepository movieRepository;

  @Autowired
  public MovieServiceV1(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie getMovieById(Long id) throws NotFoundException {
    return movieRepository.findOne(validateMovie(id));
  }

  public List<Movie> getMoviesByTitle(String title) {
    return movieRepository.findByTitle(title);
  }

  public void addMovie(Movie movie) {
    movieRepository.save(movie);
  }

  public String countMovies() {
    return movieRepository.countAllMovies();
  }

  private Long validateMovie(Long movieId) throws NotFoundException {
    return Optional.ofNullable(movieRepository.findOne(movieId))
                   .map(movie -> movie.getId())
                   .orElseThrow(() -> new NotFoundException("Movie not found"));
  }

  public void updateMovie(Long movieId, Movie movie) throws NotFoundException {
    Long id = validateMovie(movieId);
    movie.setId(id);
    movieRepository.save(movie);
  }
}
