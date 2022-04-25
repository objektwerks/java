package objektwerks;

import org.junit.jupiter.api.Test;

sealed interface Shape permits Circle, Square {
  double pi = 3.14;

  default double area() {
    return switch (this) {
        case Circle c -> pi * Math.pow(c.diameter() / 2, 2);
        case Square s -> Math.pow(s.side(), 2);
        default          -> 0.0;
    };
}
}
record Circle(double diameter) implements Shape {}
record Square(double side) implements Shape {}

/**
 * This test passes with Maven but fails with Gradle. Fix unknown at this time.
 * Intellij understands this code but VS Code does not.
 */
class RecordTest {
    @Test void recordTest() {
        Circle circle = new Circle(6.0);
        assert(circle.diameter() == 6.0);
        assert(circle.area() == 28.26);

        Square square = new Square(4.0);
        assert(square.side() == 4.0);
        assert(square.area() == 16.0);
   }

    @Test void equalsTest() {
      Shape shapeA = new Square(1.0);
      Shape shapeB = new Square(2.0);
      Shape shapeC = new Square(2.0);
      assert(!shapeA.equals(shapeB));
      assert(shapeB.equals(shapeC));
    }
}