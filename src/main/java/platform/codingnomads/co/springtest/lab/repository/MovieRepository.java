package platform.codingnomads.co.springtest.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springtest.lab.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public List<Movie> getMoviesByRatingGreaterThanEqual(Double rating);

}
