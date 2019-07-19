package ajplarson.flooringmastery;

import ajplarson.flooringmastery.controller.TheBrains;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TheBrains controller = ctx.getBean("controller", TheBrains.class);
        controller.run();
    }

}
