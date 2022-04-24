package objektwerks;

import org.junit.jupiter.api.Test;

class ControlFlowTest {
    @Test void ifTest() {
        int x = 1;
        boolean result = false;
        if (x >= 1) result = true;
        assert(result);
    }

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

    @Test void nestedIfElseTest() {
        boolean wellRested = true;
        boolean wellPrepared = true;
        String greeting = "";
        if (wellRested) {
          greeting = "Best of luck today!";  
          if (wellPrepared) {
            greeting = "You are ready for your exam!";
          } else {
            greeting = "Study before your exam!";
          }
        }
        assert(greeting == "You are ready for your exam!");
    }

    @Test void andNotOrTest() {
      int x = 1;
      assert(x > 0 && x < 2);
      assert(x != 0);
      assert(x > 0 || x < 2);
    }
}