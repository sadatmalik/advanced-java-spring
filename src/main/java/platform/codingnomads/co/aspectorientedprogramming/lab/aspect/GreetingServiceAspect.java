package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceAspect.class);

    @Around("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void targetGreetingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Before execution of: " + joinPoint.getSignature().getName());
        joinPoint.proceed();
        LOGGER.info("After returning from: " + joinPoint.getSignature().getName());
    }

    @Pointcut(value = ("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.encouragement())"))
    public void targetEncouragementMethod() {
    }

    @Before("targetEncouragementMethod()")
    public void targetEncouragementMethod(JoinPoint jp) {
        LOGGER.info("Adding an Aspect - Nice One! : " + jp.getSignature().getName());
    }
}
