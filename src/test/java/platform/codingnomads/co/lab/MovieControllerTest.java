package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepo;

    @Test
    public void testGetAllMoviesSuccess() throws Exception {
        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {
        movieRepo.deleteAll();

        // Check via Postman - does it return a 404 or just an empty json msg body?
        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllMoviesSuccessMockService() {

    }
}
