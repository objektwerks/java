package objektwerks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BasicTest {
    private Logger logger = LoggerFactory.getLogger(BasicTest.class);
    
    @Test void basic() {
        logger.info("*** BasicTest::basic: Logging is working!");
        assertEquals(1 + 1, 2);
    }
}