package pl.eninja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.eninja.domain.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  List<Movie> findByTitle(@Param("title") String title);

  @Query(value = "SELECT COUNT(*) FROM movie;",
         nativeQuery = true)
  String countAllMovies();
}