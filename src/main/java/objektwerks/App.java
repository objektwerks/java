package objektwerks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Java geek";
        String prefix = "*** ";
        System.out.println(prefix + "Hello world!");
        System.out.println(prefix + "Hello, " + name + "!");
        logger.info(prefix + "Logging is working!");
    }
}