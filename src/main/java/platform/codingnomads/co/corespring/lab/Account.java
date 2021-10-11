package platform.codingnomads.co.corespring.lab;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    private final String id;
    private final String name;
    private final String accountNumber;
}
