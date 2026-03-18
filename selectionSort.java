public class Main
{
	public static void main(String[] args) {
	    int[] a = {43,5,12,54,12,1,65,76};
	    int[] b = selectionSort(a);
		  print(b);
	}
	public static int[] selectionSort(int[] arr){
	    int innercomparisions = 0; 
	    int outercomparisions = 0; 
        for (int j=0; j<arr.length - 1 ; j++){
            int min_index=j;
        	for (int i=j+1; i<arr.length; i++){ // 1...7
        		if(arr[min_index] > arr[i]){
        			min_index = i; // 1
        		}
        		innercomparisions++;
        	}
        	int temp = arr[j];
        	arr[j] = arr[min_index];
        	arr[min_index] = temp;
        	outercomparisions++;
        	print(arr);
        }
        System.out.println(outercomparisions);
        System.out.println(innercomparisions);
        return arr;
    }
    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
        	System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    
}
