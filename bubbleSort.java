public class Main
{
	public static void main(String[] args) {
	    int[] a = {45,5,42,34,32,31,27,26};
	    int[] b = bubbleSort(a);
		print(b);
	}
	public static int[] bubbleSort(int[] arr){
	    int innercomparisions = 0; 
	    int outercomparisions = 0;
	    boolean swapped;
        for (int i = 0;i<arr.length-1;i++){
            swapped = false;
            outercomparisions++;
            // 1 2, 2 3 , 3 4, .... n-1 n
            // 1 2, 2 3 , 3 4, .... n-2 n-1 | n
            // 1 2, 2 3 , 3 4, .... n-3 n-2 | n-1 n
            for (int j = 1;j<arr.length-i;j++){ 
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    innercomparisions++;
                    swapped=true;
                }
                // As of now, Time Complexity is O(n2)
            }
            // For achieving optimization in Best Case Scenario when the array is already sorted - O(n)
            if(swapped == false){
                break;
            }
        }
        System.out.println("Outer Comparisions Made: "+outercomparisions);
        System.out.println("Inner Comparisions/Swappings Made: "+innercomparisions);
        return arr;
    }
    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
        	System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
