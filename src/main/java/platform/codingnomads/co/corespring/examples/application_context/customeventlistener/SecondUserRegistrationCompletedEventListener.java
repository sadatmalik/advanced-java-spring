package platform.codingnomads.co.corespring.examples.application_context.customeventlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * A second listener class that also listens for UserRegistrationCompletedEvent. It
 * prints "I'm a second listener!" when the event fires.
 *
 * Now have multiple listeners for a single event, this is helpful because each can do
 * different work, depending on the application requirements.
 *
 * @author sm@creativefusion.net
 */
@Component
public class SecondUserRegistrationCompletedEventListener
        implements ApplicationListener<UserRegistrationCompletedEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationCompletedEvent event) {
        System.out.println("-----I'm a second listener!-----");
    }
}
