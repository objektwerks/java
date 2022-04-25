package objektwerks;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class DateTimeTest {
    @Test void dateTest() {
        LocalDate date = LocalDate.now();
        assert(LocalDate.parse(date.toString()).equals(date));
    }

    @Test void timeTest() {
        LocalTime time = LocalTime.now();
        assert(LocalTime.parse(time.toString()).equals(time));
    }
}