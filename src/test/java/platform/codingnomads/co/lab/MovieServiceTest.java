package platform.codingnomads.co.lab;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.controller.MovieController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    @Order(1)
    public void testGetAllMoviesSuccess() {
        List<Movie> movies = movieService.getAllMovies();
        assertThat(movies.size()).isEqualTo(2);
        assertThat(movies.get(0).getName()).isEqualTo("The Shawshank Redemption");
        assertThat(movies.get(0).getRating()).isEqualTo(9.3);
        assertThat(movies.get(1).getName()).isEqualTo("The Pursuit of Happyness");
        assertThat(movies.get(1).getRating()).isEqualTo(8.0);
    }

    @Test
    @Order(2)
    public void testGetMoviesByMinimumRatingSuccess() {
        List<Movie> movies = movieService.getMoviesByMinimumRating(9.0);
        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies.get(0).getName()).isEqualTo("The Shawshank Redemption");
        assertThat(movies.get(0).getRating()).isEqualTo(9.3);
    }

    @Test
    @Order(3)
    public void testGetMoviesByMinimumRatingFailure() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            movieService.getMoviesByMinimumRating(-1d);
        });

        assertThat(exception.getMessage()).isEqualTo("Rating must specify a value between 0 and 10");
    }

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Order(4)
    public void testGetAllMoviesFailure() {

        movieRepository.deleteAll();

        List<Movie> movies = movieService.getAllMovies();
        assertThat(movies.size()).isEqualTo(0);
    }

}
