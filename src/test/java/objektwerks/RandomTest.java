package objektwerks;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

public class RandomTest {
    @Test void uuidTest() {
        var uuid = UUID.randomUUID();
        var nextUuid = UUID.randomUUID();
        assert(!uuid.equals(nextUuid));
        assert(!uuid.toString().isEmpty());
    }

    @Test void randomTest() {
        var random = new Random();
        assert(random.nextInt() != 0);
        assert(Math.abs(random.nextInt()) > 0);
    }
}