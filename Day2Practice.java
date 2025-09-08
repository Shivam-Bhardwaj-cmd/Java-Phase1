import java.util.Scanner;

public class Day2Practice {

    // Exercise 1 – Sum of array elements
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Exercise 2 – Find largest element
    public static int findLargest(int[] arr) {
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    // Exercise 3 – Count even and odd elements
    public static void countEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
    }

    // Exercise 4 – Reverse the array
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Exercise 5 – Print array elements
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Exercise 6 – Calculate average of array
    public static double calculateAverage(int[] arr) {
        int sum = calculateSum(arr);
        return (double) sum / arr.length;
    }

    // Exercise 7 – Search for a value in array
    public static int searchElement(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for array exercises
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.println("Enter " + size + " integers:");

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Exercise 1 – Sum
        System.out.println("Sum of elements: " + calculateSum(numbers));

        // Exercise 2 – Largest element
        System.out.println("Largest element: " + findLargest(numbers));

        // Exercise 3 – Even and Odd counts
        countEvenOdd(numbers);

        // Exercise 4 – Reverse array
        System.out.print("Original array: ");
        printArray(numbers);
        reverseArray(numbers);
        System.out.print("Reversed array: ");
        printArray(numbers);

        // Exercise 6 – Average
        System.out.println("Average of elements: " + calculateAverage(numbers));

        // Exercise 7 – Search for a value
        System.out.print("Enter a value to search: ");
        int key = scanner.nextInt();
        int index = searchElement(numbers, key);
        if (index != -1) {
            System.out.println("Element " + key + " found at index " + index);
        } else {
            System.out.println("Element " + key + " not found in the array.");
        }

        scanner.close();
    }
}
