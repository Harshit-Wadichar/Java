public class Sorting {

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // -------------------- Bubble Sort --------------------
        int[] bubbleArr = {7, 8, 3, 1, 2}; // Initial unsorted array

        // Bubble Sort algorithm — Time Complexity: O(n^2)
        for (int i = 0; i < bubbleArr.length - 1; i++) {
            for (int j = 0; j < bubbleArr.length - i - 1; j++) {
                if (bubbleArr[j] > bubbleArr[j + 1]) {
                    // Swap adjacent elements
                    int temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j + 1];
                    bubbleArr[j + 1] = temp;
                }
            }
        }

        System.out.print("Bubble Sort: ");
        printArray(bubbleArr);

        // -------------------- Selection Sort --------------------
        int[] selectionArr = {7, 8, 3, 1, 2}; // Initial unsorted array

        // Selection Sort algorithm — Time Complexity: O(n^2)
        for (int i = 0; i < selectionArr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < selectionArr.length; j++) {
                if (selectionArr[smallest] > selectionArr[j]) {
                    smallest = j;
                }
            }
            // Swap the smallest element with the current position
            int temp = selectionArr[smallest];
            selectionArr[smallest] = selectionArr[i];
            selectionArr[i] = temp;
        }

        System.out.print("Selection Sort: ");
        printArray(selectionArr);

        // -------------------- Insertion Sort --------------------
        int[] insertionArr = {7, 8, 3, 1, 2}; // Initial unsorted array

        // Insertion Sort algorithm — Time Complexity: O(n^2)
        for (int i = 1; i < insertionArr.length; i++) {
            int current = insertionArr[i];
            int j = i - 1;

            // Shift elements greater than current to the right
            while (j >= 0 && insertionArr[j] > current) {
                insertionArr[j + 1] = insertionArr[j];
                j--;
            }

            // Place current in its correct position
            insertionArr[j + 1] = current;
        }

        System.out.print("Insertion Sort: ");
        printArray(insertionArr);
    }
}