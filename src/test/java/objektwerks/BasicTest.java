package objektwerks;

import ch.qos.logback.classic.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

class BasicTest {
    private Logger logger = (Logger) LoggerFactory.getLogger(BasicTest.class);
    
    @Test void basic() {
        logger.info("*** Test logging is working!");
        assertEquals(1 + 1, 2);
    }
}