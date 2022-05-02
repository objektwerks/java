package objektwerks;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LoggerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    static {
        logger.info("*** Test logging is working!");
    }

    @Test void random() {
        var random = new Random();
        var optional = Stream
            .of(1, 11)
            .map( i -> random.nextInt() )
            .reduce(Integer::sum);
        int sum = optional.orElse(-1);
        logger.info("Random sum of 10 random numbers: " + sum);
        assert(sum != -1 && sum != 0);
    }
}