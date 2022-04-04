package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author sm@creativefusion.net
 */
@Component("amd")
@ToString
public class AMD implements CPU{
}
