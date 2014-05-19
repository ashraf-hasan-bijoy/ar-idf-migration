package net.therap;

import net.therap.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author ashraf
 * @since 5/15/14
 */
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        log.info("Start Migration @ {}", new Date());

        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        if (args.length != 1) {
            System.out.println("Insufficient Argument !! Enter a valid Path");
        } else {

            ctx.getBean(TestService.class).test();
        }

        log.info("End Migration @ {}", new Date());
        log.info("Elapsed time {}ms", (System.currentTimeMillis() - start));
    }
}
