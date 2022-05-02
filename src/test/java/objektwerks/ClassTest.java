package objektwerks;

import org.junit.jupiter.api.Test;

class Caveman {
    String name;
    Integer age;

    Caveman(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

interface Behavior {
    String behavior();
}

abstract class Canine implements Behavior {
    String typeOf;

    abstract String bark();
}
 
class Dog extends Canine {
    Dog() {
        super.typeOf = getClass().getSimpleName();
    }
    
    String bark() {
        return "ruf ruf";
    }

    public String behavior() {
        return "friendly";
    }
}

class ClassTest {
    @Test void classTest() {
        var caveman = new Caveman("Fred Flintstone", 25);
        assert(caveman.name.equals("Fred Flintstone"));
        assert(caveman.age == 25);
    }

    @Test void inheritenceTest() {
        var dog = new Dog();
        assert(dog.bark().equals("ruf ruf"));
    }

    @Test void interfaceTest() {
        var dog = new Dog();
        assert(dog.behavior().equals("friendly"));
    }

    @Test void anonymousClassTest() {
        var anonymous = new Behavior() {
            @Override public String behavior() {
                return "anonymous";
            }
        };
        assert(anonymous.behavior().equals("anonymous"));
    }
}