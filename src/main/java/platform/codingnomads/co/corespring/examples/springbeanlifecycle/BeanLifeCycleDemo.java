package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanLifeCycleConfig.class);
        ctx.refresh();
        final SpringBean springBean = ctx.getBean(SpringBean.class);
        //final AnotherSpringBean anotherSpringBean = ctx.getBean(AnotherSpringBean.class);
        ctx.close();
    }
}
