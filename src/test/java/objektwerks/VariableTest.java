package objektwerks;

import org.junit.jupiter.api.Test;

class VariableTest {
  @Test void bool() {
      boolean isRound = true;
      boolean isSqaure = false;
      assert(isRound);
      assert(!isSqaure);
  }
}