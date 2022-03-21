package platform.codingnomads.co.springdata.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.models.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findRouteByOrigin_Code(String originCode);

    Route findRouteByDestination_Code(String destinationCode);

    Route findRouteByCode(String code);

}
