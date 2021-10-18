package platform.codingnomads.co.springdata.lab.mylab.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "areas")
@ToString(exclude = "flights")
@Builder
public class Area implements Serializable {

    private static final long serialVersionUID = -8664726550453215096L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @ManyToMany(mappedBy = "airports")
    private List<Flight> flights;

}
