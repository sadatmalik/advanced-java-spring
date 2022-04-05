package platform.codingnomads.co.corespring.examples.propertysourceannoation;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sm@creativefusion.net
 */
@Getter
@Component
public class Fusion {

    @Value("${fusion.url}")
    private String url;

    @Value("${fusion.keycloak.url}")
    private String keycloakUrl;

}
