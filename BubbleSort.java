import java.io.*;
import java.util.*;

public class BubbleSort {
    
    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101);  // Random integer between 0 and 100
        }
        return array;
    }

   
    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.write(Integer.toString(num));
                writer.newLine();  
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

   
    public static int[] readFileToArray(String filename) {
        List<Integer> tempList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tempList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
        
        // Convert the List to an array
        int[] array = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            array[i] = tempList.get(i);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                   
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the length of the array to create:");
        int length = scanner.nextInt();
        
        int[] array = createRandomArray(length);
        
        System.out.println("Generated random array:");
        System.out.println(Arrays.toString(array));

        // Sorting the array
        bubbleSort(array);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));
        
        // Ask for the filename to write the array to a file
        System.out.println("Enter a filename to save the array:");
        scanner.nextLine();  // Consume the newline character
        String filename = scanner.nextLine();
        
        writeArrayToFile(array, filename);
        System.out.println("Array has been written to " + filename);
        
        
        int[] arrayFromFile = readFileToArray(filename);
        System.out.println("Array read from the file:");
        System.out.println(Arrays.toString(arrayFromFile));

        
        scanner.close();
    }
}
