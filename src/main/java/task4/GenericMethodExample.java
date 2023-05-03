package task4;

public class GenericMethodExample {
    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.println(element);
        }

        // Alternatively, use forEach() to print out each element
        //Arrays.asList(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"hello", "world"};

        printArray(intArr);
        printArray(strArr);
    }
}
