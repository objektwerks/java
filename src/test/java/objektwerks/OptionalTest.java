package objektwerks;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalTest {
    @Test void emptyTest() {
        var optional = Optional.<Integer>empty();
        assert(optional.isEmpty());
        assert(!optional.isPresent());
    }

    @Test void ofOrElseTest() {
        var optional = Optional.of(1);
        assert(optional.orElse(-1) == 1); // default value ALWAYS if present or empty created!
        assert(!optional.isEmpty());
        assert(optional.isPresent());
    }

    @Test void orElseGetTest() {
        var optional = Optional.<Integer>empty();
        assert(optional.orElseGet(() -> 1) == 1); // default value ONLY created when empty!
        assert(optional.isEmpty());
        assert(!optional.isPresent());
    }

    @Test void ifPresentTest() {
        var optional = Optional.of(1);
        optional.ifPresent( value -> assertEquals(value, 1) );
        assert(!optional.isEmpty());
        assert(optional.isPresent());
    }

    @Test void ofNullableTest() {
        Integer nullable = null;
        var optional = Optional.ofNullable(nullable);
        assert(optional.isEmpty());
        assert(!optional.isPresent());
    }
}