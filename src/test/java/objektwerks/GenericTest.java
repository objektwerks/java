package objektwerks;

import org.junit.jupiter.api.Test;

class Box<T> {
    private T t;

    void set(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}

class GenericTest {
    @Test void genericClassTest() {
        var box = new Box<Integer>();
        box.set(1);
        assert(box.get() == 1);
    }

    @Test void genericMethodTest() {
      
    }
}