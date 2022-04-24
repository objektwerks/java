package objektwerks;

import org.junit.jupiter.api.Test;

class VariableTest {
  @Test void booleanTest() {
      boolean isRound = true;
      boolean isSqaure = false;
      assert(isRound);
      assert(!isSqaure);
  }

  @Test void charTest() {
    char number = '1';
    char letter = 'a';
    assert(Character.isDigit(number));
    assert(Character.isLetter(letter));
    assert(number != letter);
    assert(letter == new String("a").charAt(0));
  }

  @Test void stringTest() {
    String fred = "Fred Flinstone";
    String barney = "Barney Rebel";
    assert(fred != barney);
    assert(fred.length() == 14);
    assert(barney.length() == 12);
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
}