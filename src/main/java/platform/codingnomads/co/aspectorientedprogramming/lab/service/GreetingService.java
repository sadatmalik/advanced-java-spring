package platform.codingnomads.co.aspectorientedprogramming.lab.service;

import org.springframework.stereotype.Service;
import platform.codingnomads.co.aspectorientedprogramming.lab.aspect.Printable;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello Code Warrior";
    }

    @Printable
    public String encouragement() {
        return "You got this!";
    }

}
