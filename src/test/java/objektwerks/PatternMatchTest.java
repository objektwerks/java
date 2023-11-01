package objektwerks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PatternMatchTest {
    String matchOn(Number number) {
        return switch (number) {
            case Integer i -> i.toString();
            case Long    l -> l.toString();
            case Double  d -> d.toString();
            case Float   f -> f.toString();
            default        -> "";
        };
    }

    String matchOn(String string) {
        return switch (string) {
            case String s when s.isEmpty() -> "empty";
            case String s when s.length() < 2 -> "length of 1";
            case String s when s.length() < 3 -> "length of 2";
            case String s when s.length() < 4 -> "length of 3";
            default -> "length greater than 3";
        };
    }

    record Point(int x, int y) {}

    String matchOn(Point point) {
        return switch (point) {
            case Point p when p.x < 2 && p.y < 2 -> "less than 2";
            case Point p when p.x < 3 && p.y < 3 -> "less than 3";
            case Point p when p.x < 4 && p.y < 4 -> "less than 4";
            default -> "greater than 4";
        };
    }

    String matchOn(Shape shape) {
        return switch (shape) {
            case Circle(var diameter) -> "circle(" + diameter + ")";
            case Square(var side) -> "square(" + side + ")";
        };
    }

    @Test void numberMatchTest() {
        assertEquals(matchOn(1), "1");
        assertEquals(matchOn(2.0), "2.0");
    }

    @Test void stringMatchWhenTest() {
        assertEquals(matchOn(""), "empty");
        assertEquals(matchOn("a"), "length of 1");
        assertEquals(matchOn("aa"), "length of 2");
        assertEquals(matchOn("aaa"), "length of 3");
        assertEquals(matchOn("aaaa"), "length greater than 3");
    }

    @Test void pointRecordMatchTest() {
        assertEquals(matchOn(new Point(1, 1)), "less than 2");
        assertEquals(matchOn(new Point(2, 2)), "less than 3");
        assertEquals(matchOn(new Point(3, 3)), "less than 4");
    }

    @Test void shapeRecordMatchTest() {
        assertEquals(matchOn(new Circle(6)), "circle(6.0)");
        assertEquals(matchOn(new Square(6)), "square(6.0)");
    }
}