package platform.codingnomads.co.corespring.examples.propertysourceannoation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource(value = {
        "myapp.properties",
        "fusion.properties"},
        ignoreResourceNotFound = true)
public class PropertySourceAnnotationConfig { }
