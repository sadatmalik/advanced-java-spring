package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.controller.MovieController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;
import platform.codingnomads.co.springtest.lab.service.MovieServiceImpl;
import platform.codingnomads.co.springtest.mockingmethods.RecipeMain;
import platform.codingnomads.co.springtest.mockingmethods.controllers.RecipeController;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
@ContextConfiguration(classes = SpringTestLab.class)
public class MovieControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService mockMovieService;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {

        when(
                mockMovieService.getAllMovies()
        ).thenReturn(
                List.of(
                        new Movie(1L, "Jaws", 8.3d),
                        new Movie(2L, "The Godfather", 9.1d),
                        new Movie(3L, "Dune", 8.9d),
                        new Movie(4L, "No Time To Die", 8.5d)
                )
        );

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(handler().handlerType(MovieController.class))
                .andExpect(handler().method(MovieController.class.getMethod("getAllMovies")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].name").value("Jaws"))
                .andExpect(jsonPath("$[0].rating").value(8.3))
                .andExpect(jsonPath("$[1].name").value("The Godfather"))
                .andExpect(jsonPath("$[1].rating").value(9.1))
                .andExpect(jsonPath("$[2].name").value("Dune"))
                .andExpect(jsonPath("$[2].rating").value(8.9))
                .andExpect(jsonPath("$[3].name").value("No Time To Die"))
                .andExpect(jsonPath("$[3].rating").value(8.5));


    }


}
