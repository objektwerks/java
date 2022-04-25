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

class ClassTest {
    @Test void classTest() {
        Person person = new Person("Fred Flintstone", 25);
        assert(person.name == "Fred Flintstone");
        assert(person.age == 25);
    }
}