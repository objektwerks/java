package objektwerks;

import org.junit.jupiter.api.Test;

sealed interface Shape permits Circle, Rectangle, Square {}
record Circle(double diameter) implements Shape {}
record Rectangle(double width, double height) implements Shape {}
record Square(double side) implements Shape {}

class RecordTest {
    @Test void recordTest() {
        Circle circle = new Circle(6);
        assert(circle.diameter() == 6);

        Rectangle rectangle = new Rectangle(2.0, 2.0);
        assert(rectangle.width() == 2.0);
        assert(rectangle.height() == 2.0);

        Square square = new Square(4);
        assert(square.side() == 4);
    }

    @Test void equalsTest() {
      Shape shapeA = new Rectangle(1.0, 1.0);
      Shape shapeB = new Rectangle(2.0, 2.0);
      Shape shapeC = new Rectangle(2.0, 2.0);
      assert(!shapeA.equals(shapeB));
      assert(shapeB.equals(shapeC));
    }
}