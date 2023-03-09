import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class App {

    @SuppressWarnings("unchecked")
    public static ArrayList createRandomArray(int arrayLength, String typeName) {
        ArrayList arrayList = new ArrayList(arrayLength);
        Random random = new Random();

        switch (typeName) {
            case "i":
                for (int i = 0; i < arrayLength; i++) {
                    arrayList.add(random.nextInt(100));
                }
                break;
            case "f":
                for (int i = 0; i < arrayLength; i++) {
                    arrayList.add(random.nextFloat(100));
                }
                break;
            case "d":
                for (int i = 0; i < arrayLength; i++) {
                    arrayList.add(random.nextDouble(100));
                }
                break;
            default:
                System.out.println("Unrecognized data type. Will use Integer as the grade data type.");
                for (int i = 0; i < arrayLength; i++) {
                    arrayList.add(random.nextInt(100));
                }
                break;

        }

        return arrayList;
    }

    @SuppressWarnings("un")
    public static <T extends Comparable<T>> void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease input a positive integer value for the array size that you would like: ");
            int arrayLength;
            try {
                arrayLength = scanner.nextInt();
                if (arrayLength < 1) {
                    System.out.println(
                            "Invalid input! Since you did not input a positive integer value, the program will use a default length of 10.");
                    arrayLength = 10;
                }
            } catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input! Since you did not input a positive integer value, the program will use a default length of 10.");
                scanner.next(); //clears the current entry if it is not an integer value
                arrayLength = 10;
            }
            System.out.println("\nPlease input the grade data type (choose i for Integer, f for Float, or d for Double): ");
            String typeName = scanner.next();
            ArrayList arrayList = createRandomArray(arrayLength, typeName);

            System.out.println(
                    "\nWould you like to use bubble sort or merge sort? Enter \"b\" for bubble sort or \"m\" for merge sort:");
            String bubbleMergeInput = scanner.next();
            boolean bubbleMerge;
            if (bubbleMergeInput.equalsIgnoreCase("b")) {
                bubbleMerge = true;
            } else if (bubbleMergeInput.equalsIgnoreCase("m")) {
                bubbleMerge = false;
            } else {
                System.out.println(
                        "\nInvalid choice! \nSince you did not enter either \"bubble\" or \"merge\","
                                + " the program will automatically use merge sort.");
                bubbleMerge = false;

            }

            System.out.println(
                    "\nWould you like to print the randomly generated array? Enter \"yes\" to print the array or \"no\" to not print the array:");
            String printArrayInput = scanner.next();
            boolean printArray;
            if (printArrayInput.equalsIgnoreCase("yes")) {
                printArray = true;
            } else if (printArrayInput.equalsIgnoreCase("no")) {
                printArray = false;
            } else {
                System.out.println(
                        "\nInvalid choice! \nSince you did not enter either \"yes\" or \"no\","
                                + " the array will not be printed.");
                printArray = false;

            }

            if (printArray) {
                System.out.println("\n" + arrayList.toString());
            }

            System.out.println("\nThe array is currently sorted: " + Sort.isSorted(arrayList));
            long startTime;

            if (bubbleMerge) {
                System.out.println("\nThe array is now being sorted using bubble sort.");
                startTime = System.currentTimeMillis();
                Sort.bubbleSort(arrayList);
                System.out.printf(
                        "Bubble sort took %.3f seconds to sort an array of length %d.\n",
                        (System.currentTimeMillis() - startTime) / 1000.0, arrayLength);

            } else {
                System.out.println("\nThe array is now being sorted using merge sort.");
                startTime = System.currentTimeMillis();
                Sort.mergeSort(arrayList);
                System.out.printf(
                        "Merge sort took %.3f seconds to sort an array of length %d.\n",
                        (System.currentTimeMillis() - startTime) / 1000.0, arrayLength);

            }

            if (printArray) {
                System.out.println("\n" + arrayList.toString());
            }

            System.out.println("\nThe array is currently sorted: " + Sort.isSorted(arrayList));

            System.out.println("\nWould you like to continue? Enter \"yes\" to continue or \"no\" to quit:");
            String yesNo = scanner.next();
            if (yesNo.equalsIgnoreCase("yes")) {
                continue;
            } else if (yesNo.equalsIgnoreCase("no")) {
                System.out.println("\nGoodbye!");
                break;
            } else {
                System.out.println(
                        "\nInvalid choice! \nSince you did not enter either \"yes\" or \"no\","
                                + " the program will automatically quit for you. \n\nGoodbye!");
                break;
            }

        }

        scanner.close();

    }
}
