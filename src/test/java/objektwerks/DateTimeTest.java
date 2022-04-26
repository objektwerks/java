package objektwerks;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class DateTimeTest {
    @Test void dateTimeTest() {
        var datetime = LocalDateTime.now();
        assert(LocalDateTime.parse(datetime.toString()).equals(datetime));
    }
    
    @Test void instantTest() {
        var instant = Instant.now();
        assert(Instant.parse(instant.toString()).equals(instant));
    }

    @Test void dateTest() {
        var date = LocalDate.now();
        assert(LocalDate.parse(date.toString()).equals(date));
    }

    @Test void timeTest() {
        var time = LocalTime.now();
        assert(LocalTime.parse(time.toString()).equals(time));
    }

    @Test void formatTest() {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var datetime = LocalDateTime.now();
        var datetimeAsString = formatter.format(datetime);
        var parsedDatetime = LocalDateTime.parse(datetimeAsString, formatter);
        assert(datetime.getYear() == parsedDatetime.getYear());
        assert(datetime.getMonthValue() == parsedDatetime.getMonthValue());
        assert(datetime.getDayOfMonth() == parsedDatetime.getDayOfMonth());
        assert(datetime.getHour() == parsedDatetime.getHour());
        assert(datetime.getMinute() <= parsedDatetime.getMinute());
    }
}