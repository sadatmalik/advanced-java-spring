package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author sm@creativefusion.net
 */
@Component
public class AnotherSpringBean implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("Hello, I'm a Bean. Pleased to meet you. My name is " + name);
    }
}
