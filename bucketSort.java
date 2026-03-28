import java.util.ArrayList;
import java.util.List;
public class Main
{
	public static void main(String[] args) {
	    float[] a = {0.43f,0.5f,0.12f,0.54f,0.3f,0.01f,0.65f,0.76f};
	    float[] b = bucketSort(a);
		print(b);
	}
	public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
// 	   Step 1: Create an array of size 10, where each slot represents a bucket.
// 	   Step 2: Insert elements into the buckets from the input array based on their range.
//     Step 3: Sort the elements within each bucket.
//     Step 4: Gather the elements from each bucket and put them back into the original array.
//     Step 5: The original array now contains the sorted elements.

	public static float[] bucketSort(float[] arr){
	    // Step 1
	    List<Float>[] buckets = new ArrayList[arr.length];
	    
	    for (int i = 0; i < arr.length; i++) {
            buckets[i] = new ArrayList<>();
        }
	    // Step 2
	    for (int i = 0; i < arr.length ; i++){
	        buckets[(int) (arr.length*arr[i])].add(arr[i]);
	    }
	    
	    // Step 3
        for (int i = 0; i < arr.length; i++) {
            insertionSort(buckets[i]);
        }
        
        // Step 4
	    int index = 0;
	    for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }

	    // Step 5
	    
        return arr;
    }
    public static void print(float[] arr){
        for (float num : arr) {
        	System.out.print(num + ", ");
        }
        System.out.println();
    }
}
