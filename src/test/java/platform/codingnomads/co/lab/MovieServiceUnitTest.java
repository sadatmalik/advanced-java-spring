package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;
import platform.codingnomads.co.springtest.mockingmethods.exceptions.NoSuchRecipeException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(MovieService.class)
@ContextConfiguration(classes = SpringTestLab.class)
class MovieServiceUnitTest {

    @MockBean
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @Test
    public void testGetAllMoviesSuccess() {

        List<Movie> movieList = List.of(
                new Movie(1L, "Jaws", 8.3d),
                new Movie(2L, "The Godfather", 9.1d),
                new Movie(3L, "Dune", 8.9d),
                new Movie(4L, "No Time To Die", 8.5d)
        );

        when(
                movieRepository.findAll()
        ).thenReturn(movieList);

        assertThat(movieService.getAllMovies().size()).isEqualTo(movieList.size());
        for (int i = 0; i < movieList.size(); i++){
            assertThat(movieService.getAllMovies().get(i)).isEqualTo(movieList.get(i));
        }
    }

    @Test
    public void testGetAllMoviesFailure() {
        when(movieRepository.findAll()).thenThrow(new IllegalStateException());

        assertThrows(IllegalStateException.class, () -> {
            movieService.getAllMovies();
        });
    }

    @Test
    public void testGetMoviesByMinimumRatingSuccess() {
        List<Movie> movieList = List.of(
                new Movie(1L, "Jaws", 8.3d),
                new Movie(2L, "The Godfather", 9.1d),
                new Movie(3L, "Dune", 8.9d),
                new Movie(4L, "No Time To Die", 8.5d)
        );

        when(
                movieRepository.getMoviesByRatingGreaterThanEqual(anyDouble())
        ).thenReturn(movieList);

        assertThat(movieService.getMoviesByMinimumRating(8.0d).size())
                .isEqualTo(movieList.size());

        for (int i = 0; i < movieList.size(); i++){
            assertThat(movieService.getMoviesByMinimumRating(8.0d).get(i)).isEqualTo(movieList.get(i));
        }

    }

    @Test
    public void testGetMoviesByMinimumRatingFailure() {
        when(movieRepository.getMoviesByRatingGreaterThanEqual(anyDouble()))
                .thenThrow(new IllegalStateException());

        assertThrows(IllegalStateException.class, () -> {
            movieService.getMoviesByMinimumRating(1d);
        });
    }


}