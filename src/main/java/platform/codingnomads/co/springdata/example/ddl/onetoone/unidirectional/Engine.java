package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.*;

import javax.persistence.*;

/**
 * @author sm@creativefusion.net
 */
@Entity
@Table(name = "engines")
@Getter
@Setter
@NoArgsConstructor
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "make", nullable = false)
    private String manufacturer;

    @Column(name = "size")
    private Integer capacity;
}
