package platform.codingnomads.co.corespring.examples.configurationannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan <-- don't need this
public class ConfigurationDemoConfig {
    @Bean
    public SampleClass sampleClass() {
        return new SampleClass();
    }
    @Bean
    public MySampleClass mySampleClass() {
        return new MySampleClass();
    }
}
