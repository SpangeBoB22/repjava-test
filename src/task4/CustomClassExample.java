package task4;

import java.lang.reflect.Method;

public class CustomClassExample {
    public static void main(String[] args) throws Exception {
        // Create an object of a custom class
        MyCustomClass obj = new MyCustomClass();

        // Print out all the methods and return types of the class
        Method[] methods = MyCustomClass.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName() + ", Return type: " + method.getReturnType());
        }

        // Call a specific method by name using invoke()
        Method method = MyCustomClass.class.getDeclaredMethod("myMethod", int.class, String.class);
        method.setAccessible(true); // allows access to private methods
        Object result = method.invoke(obj, 10, "hello");
        System.out.println("Result of invoking method: " + result);
    }
}

class MyCustomClass {
    private String name;

    public MyCustomClass() {
        this.name = "MyCustomClass";
    }

    private int myPrivateMethod(int x) {
        return x * 2;
    }

    public String myMethod(int x, String str) {
        return name + ": " + myPrivateMethod(x) + ", " + str;
    }
}
