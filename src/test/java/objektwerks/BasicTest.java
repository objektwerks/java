package objektwerks;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BasicTest {
    private static final Logger logger = LoggerFactory.getLogger(BasicTest.class);
    static {
        logger.info("*** Test logging is working!");
    }

    @Test void basic() {
        assertEquals(1 + 1, 2);
    }
}