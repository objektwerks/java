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

    @Test void comparisonTest() {
        var firstDate = LocalDate.of(2022, 2, 2);
        var secondDate = LocalDate.of(2022, 1, 1);
        assert(firstDate.isAfter(secondDate));
        assert(secondDate.isBefore(firstDate));
        assert(firstDate.isEqual(firstDate));
        assert(!firstDate.isEqual(secondDate));

        var newYorkZDT = ZonedDateTime.of(2019, 8, 10, 8, 0, 0, 0, ZoneId.of("America/New_York"));
        var berlinZDT = ZonedDateTime.of(2019, 8, 10, 14, 0, 0, 0, ZoneId.of("Europe/Berlin"));
        assert(!newYorkZDT.isAfter(berlinZDT));
        assert(!newYorkZDT.isBefore(berlinZDT));
        assert(newYorkZDT.isEqual(berlinZDT));
    }

    @Test void periodTest() {
        var start = LocalDate.of(2015, 2, 20);
        var end = LocalDate.of(2017, 1, 15);
        var period = Period.between(start, end);
        assert("P1Y10M26D".equals(period.toString()));
        assert(period.getYears() == 1);
        assert(period.getMonths() == 10);
        assert(period.getDays() == 26);
    }

    @Test void durationTest() {
        var start = LocalTime.of(1, 20, 25, 1024);
        var end = LocalTime.of(3, 22, 27, 1544);
        assert(Duration.between(start, end).getSeconds() == 7322);
    }
}