package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/xml-config/applicationContext.xml")
public class CoreLabConfig {

    @Bean
    public Account account() {
        return new Account("1", "HSBC", "12345678");
    }

}
