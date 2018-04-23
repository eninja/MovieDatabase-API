package pl.eninja.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(unique = true)
  private String title;

  private String description;

  private Integer year;

  private Integer runtime;

  @OneToMany(cascade = CascadeType.ALL,
             fetch = FetchType.LAZY,
             targetEntity = FilmCrewMember.class)
  private Set<FilmCrewMember> filmCrewMembers = new HashSet<>();

  @ElementCollection(targetClass = Genre.class)
  @CollectionTable(name = "genres",
                   joinColumns = @JoinColumn(name = "movie_id"))
  @Enumerated(value = EnumType.STRING)
  @Column(name = "genres")
  private Set<Genre> genres = new HashSet<>();

  @ElementCollection(targetClass = Award.class)
  @CollectionTable(name = "awards",
                   joinColumns = @JoinColumn(name = "movie_id"))
  @Enumerated(value = EnumType.STRING)
  @Column(name = "awards")
  private Set<Award> awards = new HashSet<>();

  @ElementCollection(targetClass = String.class)
  @CollectionTable(name = "countries",
                   joinColumns = @JoinColumn(name = "movie_id"))
  @Column(name = "countries")
  private Set<String> countries = new HashSet<>();
}
