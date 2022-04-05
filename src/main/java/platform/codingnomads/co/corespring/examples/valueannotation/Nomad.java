package platform.codingnomads.co.corespring.examples.valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class Nomad {

    private String name;

    private Integer age;

    public Nomad(@Value("${nomad.name}") String name, @Value("${nomad.age}") Integer age) {
        this.name = name;
        this.age = age;
    }

    @Value("Hello!!")
    private String greeting;

    @Value("${nomad.framework}")
    private String framework;

    @Value("${nomad.jdk}")
    private String jdk;

    // if Spring doesn't find the value of nomad.ide in the application.properties file,
    // it will use the default provided - IntelliJ IDEA
    @Value("${nomad.ide:IntelliJ IDEA}")
    private String ide;

    // reads a list of values from properties - nomad.workingDays=Mon,Tue,Wed,Thu,Fri
    @Value("${nomad.workingDays}")
    private List<String> workingDays;

    // inject key-value pairs from properties
    // database.values={url:'http://127.0.0.1:3306/', db:'codingnomads', username:'codingnomads', password:'codingnomads'}
    @Value("#{${database.values}}")
    private Map<String, String> databaseValues;

    @Value("${nomad.email}")
    private String email;

    @Value("#{${nomad.phone}}")
    private Map<String, String> phoneNums;

    public String nomadIdentity() {
        return name.concat(" ").concat(age.toString());
    }

    public String getGreeting() {
        return greeting;
    }

    public String output() {
        return "Spring Developer is building awesome software using: ".concat(jdk).concat(" , ").concat(framework).concat(" and ").concat(ide);
    }

    public List<String> getWorkingDays() {
        return workingDays;
    }

    public Map<String, String> getDatabaseValues() {
        return databaseValues;
    }

    public String getContactInfo() {
        return "Email: ".concat(email)
                .concat(", Phone: ")
                .concat(phoneNums.toString());
    }
}
