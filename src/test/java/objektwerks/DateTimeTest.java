package objektwerks;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class DateTimeTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test void dateTimeTest() {
        LocalDateTime datetime = LocalDateTime.now();
        assert(LocalDateTime.parse(datetime.toString()).equals(datetime));
    }
    
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