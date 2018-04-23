package pl.eninja.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FilmCrewMember {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String surname;

  private FilmCrewMember(Builder builder) {
    setId(builder.id);
    setName(builder.name);
    setSurname(builder.surname);
  }

  public static final class Builder {
    private Long id;

    private String name;

    private String surname;

    public Builder() {
    }

    public Builder id(Long val) {
      id = val;
      return this;
    }

    public Builder name(String val) {
      name = val;
      return this;
    }

    public Builder surname(String val) {
      surname = val;
      return this;
    }

    public FilmCrewMember build() {
      return new FilmCrewMember(this);
    }
  }
}
