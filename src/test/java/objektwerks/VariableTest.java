package objektwerks;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

class VariableTest {
  @Test void booleanTest() {
      var isRound = true;
      var isSqaure = false;
      assert(isRound);
      assert(!isSqaure);
  }

  @Test void charTest() {
      var number = '1';
      var letter = 'a';
      assert(Character.isDigit(number));
      assert(Character.isLetter(letter));
      assert(number != letter);
      assert(letter == "a".charAt(0));
  }

  @Test void stringTest() {
      var fred = "Fred Flintstone";
      var barney = "Barney Rebel";
      assert(fred != barney);
      assert(!fred.equals(barney));
      assert(fred.concat(barney).equals(fred + barney));

      assert(fred.length() == 15);
      assert(barney.length() == 12);

      assert(barney.toLowerCase().equals("barney rebel"));
      assert(fred.toUpperCase().equals("FRED FLINTSTONE"));

      assert(fred.indexOf("stone") == 10);
      assert(fred.startsWith("Fred"));
      assert(barney.endsWith("Rebel"));
  }

  @Test void textBlockTest() {
      var text = """
            The lazy brown fox jumped over the
            fence, and was never seen again!""";
      assert(text.length() == 67);
  }

  @Test void byteTest() {
      byte low = 1;
      byte high = 127;
      assert(low > 0 && high < 128);
  }

  @Test void shortTest() {
      short low = 1;
      short high = 32767;
      assert(low > 0 && high < 32768);
  }

  @Test void intTest() {
      int positive = 10;
      int negative = -5;
      int zero = 0; 
      assert(positive > 0 && positive == 10);
      assert(negative < 0 && negative == -5);
      assert(zero == 0);
  }

  @Test void longTest() {
      long low = Long.MIN_VALUE;
      long high = Long.MAX_VALUE;
      assert(low >= Long.MIN_VALUE && high <= Long.MAX_VALUE);
  }

  @Test void floatTest() {
      float low = Float.MIN_VALUE;
      float high = Float.MAX_VALUE;
      assert(low >= Float.MIN_VALUE && high <= Float.MAX_VALUE);
  }

  @Test void doubleTest() {
      double positive = 10.5;
      double negative = -5.5;
      double zero = 0.0; 
      assert(positive > 0.0 && positive == 10.5);
      assert(negative < 0.0 && negative == -5.5);
      assert(zero == 0.0);
  }

  @Test void finalTest() {
      final double immutablePI = 3.14;
      assert(immutablePI > 3.13);
  }

  @Test void mathTest() {
      int x = 20;
      int y = 10;
      assert(x + y == 30);
      assert(x - y == 10);
      assert(x * y == 200);
      assert(x / y == 2);
      assert(x % 2 == 0 && y % 2 == 0); 
  }

  @Test void comparisonTest() {
      int x = 1;
      int y = 2;
      assert(y > x);
      assert(x < y);
      assert(y >= x && x <= y);
      assert(x == 1 && y == 2);
      assert(x != y);
  }

  @Test void compoundAssignmentTest() {
      int x = 5;
      assert(8 == (x += 3));
      assert(4 == (x -= 4));
      assert(24 == (x *= 6));
      assert(12 == (x /= 2));
      assert(5 == (x %= 7));
  }

  @Test void incrementDecrementTest() {
    int x = 1;
    x++;
    assert(x == 2);
    x--;
    assert(x == 1);
  }

  @Test void uuidTest() {
      var uuid = UUID.randomUUID();
      var nextUuid = UUID.randomUUID();
      assert(!uuid.equals(nextUuid));
      assert(!uuid.toString().isEmpty());
  }
}