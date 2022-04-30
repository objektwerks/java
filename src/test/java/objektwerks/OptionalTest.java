package objektwerks;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class OptionalTest {
    @Test void emptyTest() {
        var optional = Optional.<Integer>empty();
        assert(optional.isEmpty());
        assert(!optional.isPresent());
    }

    @Test void ofTest() {
        var optional = Optional.of(1);
        assert(!optional.isEmpty());
        assert(optional.isPresent());
        assert(optional.orElse(-1) == 1);
    }

    @Test void ofNullableTest() {
        Integer nullable = null;
        var optional = Optional.ofNullable(nullable);
        assert(optional.isEmpty());
        assert(!optional.isPresent());
    }
}