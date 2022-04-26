package objektwerks;

import org.junit.jupiter.api.Test;

class Person {
    String name;
    Integer age;

    Person(String name, Integer age) {
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
        var person = new Person("Fred Flintstone", 25);
        assert(person.name.equals("Fred Flintstone"));
        assert(person.age == 25);
    }

    @Test void inheritenceTest() {
        var dog = new Dog();
        assert(dog.bark().equals("ruf ruf"));
    }

    @Test void interfaceTest() {
        var dog = new Dog();
        assert(dog.behavior().equals("friendly"));
    }
}