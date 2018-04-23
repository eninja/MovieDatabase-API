package pl.eninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.eninja.domain.Award;
import pl.eninja.domain.FilmCrewMember;
import pl.eninja.domain.Genre;
import pl.eninja.domain.Movie;
import pl.eninja.repository.MovieRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DbInitializer implements CommandLineRunner {

  private MovieRepository movieRepository;

  @Autowired
  public DbInitializer(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Override
  public void run(String... strings) {

    Set<Genre> matrixGenres = new HashSet<>();
    matrixGenres.add(Genre.SCI_FI);
    matrixGenres.add(Genre.DRAMAT);
    matrixGenres.add(Genre.ACTION);

    Set<Award> matrixAwards = new HashSet<>();
    matrixAwards.add(Award.OSCARS);
    matrixAwards.add(Award.BAFTA);

    Set<String> matrixCountries = new HashSet<>();
    matrixCountries.add("USA");
    matrixCountries.add("Australia");

    Set<FilmCrewMember> matrixMembers = new HashSet<>();
    matrixMembers.add(new FilmCrewMember.Builder().name("Andrew").surname("Wachowski").build());
    matrixMembers.add(new FilmCrewMember.Builder().name("Laurence").surname("Wachowski").build());
    matrixMembers.add(new FilmCrewMember.Builder().name("Keanu").surname("Reeves").build());
    matrixMembers.add(new FilmCrewMember.Builder().name("Laurence").surname("Fishburne").build());
    matrixMembers.add(new FilmCrewMember.Builder().name("Carrie-Anne").surname("Moss").build());

    String MatrixDescription = "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.";

    Movie matrix = Movie.builder()
                        .title("Matrix")
                        .year(1993)
                        .runtime(135)
                        .genres(matrixGenres)
                        .awards(matrixAwards)
                        .countries(matrixCountries)
                        .filmCrewMembers(matrixMembers)
                        .description(MatrixDescription)
                        .
                                build();

    Set<Genre> TwelveAngryMenGenres = new HashSet<>();
    TwelveAngryMenGenres.add(Genre.DRAMAT);

    Set<Award> TwelveAngryMenAwards = new HashSet<>();
    TwelveAngryMenAwards.add(Award.OSCARS);
    TwelveAngryMenAwards.add(Award.BAFTA);
    TwelveAngryMenAwards.add(Award.GOLDENGLOBE);

    Set<String> TwelveAngryMenCountries = new HashSet<>();
    TwelveAngryMenCountries.add("USA");

    Set<FilmCrewMember> TwelveAngryMenMembers = new HashSet<>();
    TwelveAngryMenMembers.add(new FilmCrewMember.Builder().name("Sidney").surname("Lumet").build());
    TwelveAngryMenMembers.add(new FilmCrewMember.Builder().name("Reginald")
                                                          .surname("Rose")
                                                          .build());
    TwelveAngryMenMembers.add(new FilmCrewMember.Builder().name("Henry").surname("Fonda").build());
    TwelveAngryMenMembers.add(new FilmCrewMember.Builder().name("Lee").surname("Cobb").build());
    TwelveAngryMenMembers.add(new FilmCrewMember.Builder().name("Martin")
                                                          .surname("Balsam")
                                                          .build());
    String TwelveAngryMenDescription = "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.";

    Movie twelveAngryMen = Movie.builder()
                                .title("12 Angry Men")
                                .year(1957)
                                .runtime(96)
                                .genres(TwelveAngryMenGenres)
                                .awards(TwelveAngryMenAwards)
                                .countries(TwelveAngryMenCountries)
                                .filmCrewMembers(TwelveAngryMenMembers)
                                .description(TwelveAngryMenDescription)
                                .
                                        build();

    Set<Genre> PulpFictionGenres = new HashSet<>();
    PulpFictionGenres.add(Genre.ACTION);
    PulpFictionGenres.add(Genre.BLACK_COMEDY);

    Set<Award> PulpFictionAwards = new HashSet<>();
    PulpFictionAwards.add(Award.OSCARS);
    PulpFictionAwards.add(Award.GOLDENGLOBE);

    Set<String> PulpFictionCountries = new HashSet<>();
    PulpFictionCountries.add("USA");

    Set<FilmCrewMember> PulpFictionMembers = new HashSet<>();
    PulpFictionMembers.add(new FilmCrewMember.Builder().name("Quentin")
                                                       .surname("Tarantino")
                                                       .build());
    PulpFictionMembers.add(new FilmCrewMember.Builder().name("John").surname("Travolta").build());
    PulpFictionMembers.add(new FilmCrewMember.Builder().name("Samuel").surname("Jackson").build());
    PulpFictionMembers.add(new FilmCrewMember.Builder().name("Bruce").surname("Willis").build());
    PulpFictionMembers.add(new FilmCrewMember.Builder().name("Uma").surname("Thurman").build());
    String PulpFictionDescription = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.";

    Movie pulpFiction = Movie.builder()
                             .title("Pulp Fiction")
                             .year(1994)
                             .runtime(154)
                             .genres(PulpFictionGenres)
                             .awards(PulpFictionAwards)
                             .countries(PulpFictionCountries)
                             .filmCrewMembers(PulpFictionMembers)
                             .description(PulpFictionDescription)
                             .
                                     build();

    this.movieRepository.save(matrix);
    this.movieRepository.save(twelveAngryMen);
    this.movieRepository.save(pulpFiction);
  }
}
