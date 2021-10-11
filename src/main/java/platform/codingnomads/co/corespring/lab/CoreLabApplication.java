package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreLabApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CoreLabConfig.class);
        Account account = (Account) ctx.getBean("account");
        User user = (User) ctx.getBean("user");
        System.out.println("Account info: " + account);
        System.out.println("User info: " + user);
    }
}
