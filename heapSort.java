public class HeapSortDivideConquer {

    // Heap Sort
    public static void heapSort(int[] arr) {

        // Build Max Heap using recursive divide-and-conquer
        heapify(arr, arr.length, 0);

        // Extract elements one by one
        for (int i = arr.length - 1; i > 0; i--) {

            // Move current root (largest) to end
            swap(arr, 0, i);

            // Restore heap property on remaining heap
            fixHeap(arr, i, 0);
        }
    }

    // Recursive Divide-and-Conquer Heap Construction
    private static void heapify(int[] arr, int n, int root) {

        if (root >= n)
            return;

        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // Divide
        heapify(arr, n, left);
        heapify(arr, n, right);

        // Conquer (fix heap at current root)
        fixHeap(arr, n, root);
    }

    // Fix Heap (Max Heap)
    private static void fixHeap(int[] arr, int n, int root) {

        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != root) {
            swap(arr, root, largest);

            // Continue fixing downward
            fixHeap(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}
