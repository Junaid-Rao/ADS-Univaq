public class Main
{
	public static void main(String[] args) {
	    int[] a = {3,5,1,4,2,1,6,7};
	    int[] b = integerSort(a);
		print(b);
	}
	public static int[] integerSort(int[] arr){
	    if (arr == null || arr.length == 0) {
            return arr;
        }

        // Find maximum element (k)
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
	    // Make the array of k elements
	    int[] count = new int[max + 1];

	    // Initialize them with 0 : Java Automatically does this..
	    
	    // Loop through unsorted array and increase counters for indexes for which the element is Present
	    for (int num : arr) {
            count[num]++;
        }
        
	    // Based on New Integer Count Array, reassign the original array with new elements.
        int index = 0;
        for (int value = 0; value <= max; value++) {
            while (count[value] > 0) {
                arr[index++] = value;
                count[value]--;
            }
        }
        
        return arr;
        
	    
	    // Time complexity would be O(k+n). Into the best case, when k ~ n. 
	    // Space complexity would be of Count Array = O(k)
	    
        return arr;
    }
    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
        	System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    
}
