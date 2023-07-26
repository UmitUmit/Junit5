package practice_java;

class Superclass {
    public static void staticMethod() {
        System.out.println("Superclass static method");
    }
    public  void instanceMethod() {
        System.out.println("Superclass instance method");
    }
}

class Subclass extends Superclass {

    public static void staticMethod() {
        System.out.println("Subclass static method");
    }

    public  void instanceMethod() {
        System.out.println("Subclass instance method");
    }
}

public class Main {
    public static void main(String[] args) {
        Superclass.staticMethod(); // Calls superclass static method
        Subclass.staticMethod(); // Calls subclass static method
        Superclass s = new Subclass();
        s.instanceMethod();
    }
}

