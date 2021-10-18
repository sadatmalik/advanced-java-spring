package platform.codingnomads.co.springdata.lab.mylab.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flights")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "flights_airports",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private List<Area> airports;

    @ManyToMany
    @JoinTable(
            name = "flights_routes",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    private List<Route> routes;

    @PostLoad
    private void printLoaded() {
        System.out.println("Retrieved Flight from DB: " + this);
    }
}
