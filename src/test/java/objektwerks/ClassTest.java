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
    abstract String bark();
    public abstract String behavior();
}
 
class Dog extends Canine {
    String bark() {
        return "ruf ruf";
    }
    public String behavior() {
        return "friendly";
    }
}

class ClassTest {
    @Test void classTest() {
        Person person = new Person("Fred Flintstone", 25);
        assert(person.name == "Fred Flintstone");
        assert(person.age == 25);
    }

    @Test void inheritenceTest() {
        Dog dog = new Dog();
        assert(dog.bark() == "ruf ruf");
    }

    @Test void interfaceTest() {
        Dog dog = new Dog();
        assert(dog.behavior() == "friendly");
    }
}