package tasks.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter array size
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        // Prompt user to enter array elements
        int[] arr = new int[size];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Reverse the array
        int[] reversedArr = new int[size];
        for (int i = 0; i < size; i++) {
            reversedArr[i] = arr[size - i - 1];
        }

        // Create HashMap from reversed array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(i, reversedArr[i]);
        }

        // Add a key-value pair to the map
        map.put(size, 999);

        // Remove a key-value pair from the map
        map.remove(2);

        // Check if a key is in the map
        boolean containsKey = map.containsKey(4);
        System.out.println("Key 4 is in map: " + containsKey);

        // Find the value associated with a given key
        int value = map.get(3);
        System.out.println("Value for key 3 is: " + value);

        // Print all the keys and values in the map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Create a custom ArrayIndexOutOfBoundsException
        try {
            int x = reversedArr[size]; // accessing index outside the bounds of the array
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
            System.out.println("Explanation: The array size is " + size + ", but the index " + size + " was accessed.");
        }
    }
}
