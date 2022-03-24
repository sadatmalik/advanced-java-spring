package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Info info;

    public SpringDeveloper(Address address, Info info) {
        this.address = address;
        this.info = info;
    }
}
