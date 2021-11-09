package platform.codingnomads.co.springtest.lab;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringTestLab implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Autowired
    public SpringTestLab(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringTestLab.class);
    }

    @Override
    public void run(String... args) {
        if (movieRepository.findAll().isEmpty()) {
            movieRepository.saveAll(Arrays.asList(
                    Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                    Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
            ));
        }
    }
}
