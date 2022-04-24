package objektwerks;

import org.junit.jupiter.api.Test;

class ControlFlowTest {
    @Test void ifElseTest() {
        int x = 1;
        boolean result;
        if (x >= 1) {
            result = true;
         } else {
            result = false;
         }
         assert(result);
    }
}