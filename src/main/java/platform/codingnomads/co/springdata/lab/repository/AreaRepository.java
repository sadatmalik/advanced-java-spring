package platform.codingnomads.co.springdata.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;

public interface AreaRepository extends JpaRepository<Area,Long> {

    // find an Area by Code
    Area findByCode(String code);

}
