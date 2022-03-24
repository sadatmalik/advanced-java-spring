package platform.codingnomads.co.corespring.examples.beanscopes.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletonDemoConfig {
    @Bean
    @Scope(value = "singleton")
    public SpringBean springBean() {
        return new SpringBean();
    }

    // spring bean scope is singleton by default - omitting the singleton
    // scope still results in a singleton bean being managed
    @Bean
    public AnotherSpringBean anotherSpringBean() {
        return new AnotherSpringBean();
    }

}