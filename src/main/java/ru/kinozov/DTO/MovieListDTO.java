package ru.kinozov.DTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class MovieListDTO {
    private int id;
    private String title;
    private LocalDate releaseDate;
    private String posterPath;
    private float avgRating;
    private Set<GenreDTO> genres;
}
