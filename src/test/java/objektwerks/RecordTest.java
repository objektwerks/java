package objektwerks;

import org.junit.jupiter.api.Test;

sealed interface Shape permits Circle, Square {
  double pi = 3.14;

  default double area() {
    return switch (this) {
        case Circle circle -> pi * Math.pow(circle.diameter() / 2, 2);
        case Square square -> Math.pow(square.side(), 2);
    };
}
}
record Circle(double diameter) implements Shape {}
record Square(double side) implements Shape {}

/**
 * This test passes with Maven but fails with Gradle. Fix unknown at this time.
 */
class RecordTest {
    @Test void recordTest() {
        var circle = new Circle(6.0);
        assert(circle.diameter() == 6.0);
        assert(circle.area() == 28.26);

        var square = new Square(4.0);
        assert(square.side() == 4.0);
        assert(square.area() == 16.0);
   }

    @Test void equalsTest() {
      var shapeA = new Square(1.0);
      var shapeB = new Square(2.0);
      var shapeC = new Square(2.0);
      assert(!shapeA.equals(shapeB));
      assert(shapeB.equals(shapeC));
    }
}