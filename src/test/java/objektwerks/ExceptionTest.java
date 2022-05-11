package objektwerks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionTest {
    @Test void checkedTest() {

    }

    @Test void uncheckedTest() {
        assertThrows(NumberFormatException.class, () -> {
            var i = Integer.parseInt("one");
            assert(i == 1);
        });
    }
}