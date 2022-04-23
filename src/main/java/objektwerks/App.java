package objektwerks;

public class App {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Java geek";
        String prefix = "*** App: ";
        System.out.println(prefix + "Hello world!");
        System.out.println(prefix + "Hello, " + name + "!");
    }
}