package objektwerks;

public class Main {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Java geek";
        System.out.println("Hello world!");
        System.out.println("Hello, " + name + "!");
    }
}