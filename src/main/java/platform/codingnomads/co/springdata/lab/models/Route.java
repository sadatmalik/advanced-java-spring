package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude = "flights")
public class Route implements Serializable {
    private static final long serialVersionUID = -2624055642258734917L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "origin_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_origin_area_id")
    )
    private Area origin;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "destination_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_destination_area_id")
    )
    private Area destination;

    @ManyToMany(mappedBy = "routes")
    private List<Flight> flights;

    @PrePersist
    @PreUpdate
    private void updateCode() {
        if (origin.getCode() == null || destination.getCode() == null) {
            throw new IllegalStateException("Origin/Destination cannot be null on update/persist");
        }
        code = origin.getCode() + "-" + destination.getCode();
    }

    @PostPersist
    @PostUpdate
    private void printSaved() {
        System.out.println("Saved route to DB: " + this);
    }

    @PostLoad
    private void printLoaded() {
        System.out.println("Retrieved route from DB: " + this);
    }
}