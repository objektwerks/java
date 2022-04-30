package objektwerks;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class OptionalTest {
    @Test void optionalTest() {
        var empty = Optional.<Integer>empty();
        assert(!empty.isPresent());

        var optional = Optional.of(1);
        assert(optional.isPresent());
        assert(optional.orElse(-1) == 1);
    }
}