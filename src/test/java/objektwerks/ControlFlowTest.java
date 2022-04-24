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

    @Test void elseIfTest() {
        int score = 76;
        char grade;
        if (score >= 90) {
          grade = 'A';
        } else if (score >= 80) {
          grade = 'B';
        } else if (score >= 70) {
          grade = 'C';
        } else if (score >= 60) {
          grade = 'D';
        } else {
          grade = 'F';
        }
        assert(grade == 'C');
  }
}