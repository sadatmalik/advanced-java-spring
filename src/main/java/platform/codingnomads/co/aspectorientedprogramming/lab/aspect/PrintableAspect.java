package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceAspect.class);

    @Pointcut(value = ("@annotation(Printable)"))
    public void printable() {
    }

    @After("printable()")
    public void print(JoinPoint jp) {
        LOGGER.info("I'm printable too - printing after: " + jp.getSignature().getName());
    }
}
