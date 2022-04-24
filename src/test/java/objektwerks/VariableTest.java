package objektwerks;

import org.junit.jupiter.api.Test;

class VariableTest {
  @Test void bool() {
      boolean isRound = true;
      boolean isSqaure = false;
      assert(isRound);
      assert(!isSqaure);
  }

  @Test void string() {
    String fred = "Fred Flinstone";
    String barney = "Barney Rebel";
    assert(fred != barney);
    assert(fred.length() == 14);
    assert(barney.length() == 12);
  }
}