package objektwerks;

import java.time.*;

import org.junit.jupiter.api.Test;

class DateTimeTest {
    @Test void instantTest() {
        Instant instant = Instant.now();
        assert(Instant.parse(instant.toString()).equals(instant));
    }

    @Test void dateTest() {
        LocalDate date = LocalDate.now();
        assert(LocalDate.parse(date.toString()).equals(date));
    }

    @Test void timeTest() {
        LocalTime time = LocalTime.now();
        assert(LocalTime.parse(time.toString()).equals(time));
    }
}