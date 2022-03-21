package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Flight;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repository.AreaRepository;
import platform.codingnomads.co.springdata.lab.repository.FlightRepository;
import platform.codingnomads.co.springdata.lab.repository.RouteRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepo;
    private final RouteRepository routeRepo;
    private final FlightRepository flightRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {

        if (areaRepo.findAll().isEmpty()) {
            final List<Area> areas = areaRepo.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build()
                    )
            );
        }

        if (routeRepo.findAll().isEmpty()) {
            Route route1 = Route.builder()
                    .origin(areaRepo.findByCode("Y"))
                    .destination(areaRepo.findByCode("Z"))
                    .build();

            routeRepo.save(route1);
        }

        if (flightRepo.findAll().isEmpty()) {
            Flight flight = Flight.builder()
                    .airports(
                            Arrays.asList(
                                    areaRepo.findByCode("Y"),
                                    areaRepo.findByCode("Z")
                            )
                    )
                    .routes(
                            Arrays.asList(
                                    routeRepo.findRouteByCode("Y-Z")
                            )
                    )
                    .build();

            flightRepo.save(flight);
        }

        // automatically print when loaded
        System.out.println("1 ");
        routeRepo.findRouteByOrigin_Code("Y");

        System.out.println("2 ");
        routeRepo.findRouteByDestination_Code("Z");

        System.out.println("3 ");
        routeRepo.findRouteByCode("Y-Z");

        System.out.println("4 ");
        flightRepo.findFlightsByAirports_Code("Y");
    }
}
