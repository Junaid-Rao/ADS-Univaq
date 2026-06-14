public class Main {
    public static void main(String[] args) {

        int[] arr = {45, 5, 42, 34, 32, 31, 27, 26};

        System.out.println("Original Array:");
        print(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nFinal Sorted Array:");
        print(arr);
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            System.out.print("After partition (pivot = "
                    + arr[pivotIndex] + "): ");
            print(arr);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                if (i != j) {
                    swap(arr, i, j);
                }
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {

        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}
