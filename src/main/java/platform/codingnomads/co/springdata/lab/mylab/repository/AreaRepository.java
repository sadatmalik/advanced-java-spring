package platform.codingnomads.co.springdata.lab.mylab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.mylab.domain.Area;

public interface AreaRepository extends JpaRepository<Area,Long> {

    // find an Area by Code
    Area findByCode(String code);

}
