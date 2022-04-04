package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author sm@creativefusion.net
 */
@Component("intel")
@ToString
public class Intel implements CPU {
}
