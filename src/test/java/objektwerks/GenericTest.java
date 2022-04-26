package objektwerks;

import org.junit.jupiter.api.Test;

class Box<T> {
    static <T> boolean compare(Box<T> b1, Box<T> b2) {
        return b1.get().equals(b2.get());
    }

    private T t;

    void set(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}

class GenericTest {
    @Test void classTest() {
        var box = new Box<Integer>();
        box.set(1);
        assert(box.get() == 1);
    }

    @Test void methodTest() {
        var box1 = new Box<Integer>();
        var box2 = new Box<Integer>();
        var box3 = new Box<Integer>();
        box1.set(1);
        box2.set(2);
        box3.set(1);
        assert(!Box.compare(box1, box2));
        assert(Box.compare(box1, box3));

    }
}