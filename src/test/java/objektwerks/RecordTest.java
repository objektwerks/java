package objektwerks;

import org.junit.jupiter.api.Test;

record Rectangle(double width, double height) {}

class RecordTest {
    @Test void recordTest() {
        Rectangle rectangle = new Rectangle(2.0, 2.0);
        assert(rectangle.width() == 2.0);
        assert(rectangle.height() == 2.0);
    }
}