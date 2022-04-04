package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author sm@creativefusion.net
 */
@Component
@ToString
public class LaptopComputer {

    @Autowired
    @Qualifier("geforce")
    private VideoCard videoCard;

    @Autowired
    @Qualifier("intel")
    private CPU cpu;
}
