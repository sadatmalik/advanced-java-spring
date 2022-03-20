package platform.codingnomads.co.aspectorientedprogramming.lab;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService;

@SpringBootApplication
@RequiredArgsConstructor
public class AOPLab implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPLab.class);

    public final GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(AOPLab.class);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info(greetingService.greeting()); //not sure why this prints null?
        LOGGER.info(greetingService.encouragement());
    }
}
