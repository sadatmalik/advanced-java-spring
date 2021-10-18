package platform.codingnomads.co.springdata.lab.mylab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.mylab.domain.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findRouteByOrigin_Code(String originCode);

    Route findRouteByDestination_Code(String destinationCode);

    Route findRouteByCode(String code);

}
