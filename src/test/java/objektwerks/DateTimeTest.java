package objektwerks;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class DateTimeTest {
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

    @Test void formatTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime datetime = LocalDateTime.now();
        String datetimeAsString = formatter.format(datetime);
        LocalDateTime parsedDatetime = LocalDateTime.parse(datetimeAsString, formatter);
        assert(datetime.getYear() == parsedDatetime.getYear());
        assert(datetime.getMonthValue() == parsedDatetime.getMonthValue());
        assert(datetime.getDayOfMonth() == parsedDatetime.getDayOfMonth());
        assert(datetime.getHour() == parsedDatetime.getHour());
        assert(datetime.getMinute() <= parsedDatetime.getMinute());
    }
}