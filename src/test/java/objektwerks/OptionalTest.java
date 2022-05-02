package objektwerks;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionalTest {
    @Test void emptyTest() {
        var optional = Optional.<Integer>empty();
        assert(optional.isEmpty());
        assert(!optional.isPresent());
    }

    @Test void ofNullableTest() {
        Integer nullable = null;
        var optional = Optional.ofNullable(nullable);
        assert(optional.isEmpty());
        assert(!optional.isPresent());
    }

    @Test void orTest() {
        assert(Optional.<Integer>empty().or(() -> Optional.of(1)).get() == 1);
    }

    @Test void getTest() {
        var optional = Optional.of(1);
        assert(optional.get() == 1);
    }

    @Test void orElseTest() {
        var optional = Optional.of(1);
        assert(optional.orElse(-1) == 1); // default value ALWAYS if present or empty created!
    }

    @Test void orElseGetTest() {
        var optional = Optional.<Integer>empty();
        assert(optional.orElseGet(() -> 1) == 1); // default value ONLY created when empty!
    }

    @Test void orElseThrowTest() {
        Integer nullable = null;
        assertThrows(NoSuchElementException.class, () -> {
            Optional.ofNullable(nullable).orElseThrow();
        });
    }

    @Test void ifPresentTest() {
        var optional = Optional.of(1);
        optional.ifPresent( value -> assertEquals(value, 1) );
    }

    @Test void mapTest() {
        assert(Optional.of(4).map(Math::sqrt).get() == 2.0);
    }

    @Test void flatMapTest() {
        var box = new Box<Integer>();
        box.set(-1);
        var optionalBox = Optional.of(box);
        assert(optionalBox.flatMap( b -> Optional.of( Math.abs( b.get() ) ) ).orElse(-1) == 1);
    }

    @Test void filterTest() {
        assert(Optional.of(2).filter( i -> i % 2 == 0 ).isPresent());
    }

    @Test void listOfOptionalTest() {
        var list = Arrays.<Optional<String>>asList(
            Optional.empty(), Optional.of("a"), Optional.empty(), Optional.of("b"), Optional.empty()
        );
        var concatenated = list.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .reduce(String::concat);
        assert(concatenated.orElse("").equals("ab"));
    }
}