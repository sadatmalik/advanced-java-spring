package platform.codingnomads.co.springdata.lab.mylab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.mylab.domain.Flight;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findFlightsByAirports_Code(String code);

}
