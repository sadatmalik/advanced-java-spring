package platform.codingnomads.co.corespring.lab;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private final String id;
    private final String firstname;
    private final String lastname;
}
