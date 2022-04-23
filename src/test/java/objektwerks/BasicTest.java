package objektwerks;

import ch.qos.logback.classic.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

class BasicTest {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(BasicTest.class);
    static {
        logger.info("*** Test logging is working!");
    }

    @Test void basic() {
        assertEquals(1 + 1, 2);
    }
}