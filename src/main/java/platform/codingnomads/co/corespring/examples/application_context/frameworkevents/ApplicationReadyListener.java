package platform.codingnomads.co.corespring.examples.application_context.frameworkevents;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * A Spring event listener class. Similar to ContextRefreshedListener. This time,
 * it listens for the ApplicationReadyEvent, and print "Application Ready!" when
 * triggered.
 *
 * @author sm@creativefusion.net
 */
@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent event) {
        System.out.println("Application ready!");
    }
}
