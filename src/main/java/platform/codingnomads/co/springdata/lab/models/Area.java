package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "areas")
@Builder
@ToString(exclude = "flights")
public class Area implements Serializable {

    private static final long serialVersionUID = 153236560504273881L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToMany(mappedBy = "airports")
    private List<Flight> flights;

}