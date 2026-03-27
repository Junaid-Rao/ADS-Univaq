public class Main
{
	public static void main(String[] args) {
	    int[] a = {45,5,42,34,32,31,27,26};
        System.out.println("QuickSort Steps:");
	    quickSort(a, 0, a.length-1);
        System.out.println("Final Sorted Array:");
		print(a);
	}
	public static void quickSort(int[] arr, int low, int high){
	    if(low<high){
	        int pivot = partition(arr, low, high);
	        quickSort(arr, low, pivot-1);
	        quickSort(arr, pivot+1, high);
	    }
	}
    public static int partition(int[] arr, int low, int high){
	    int pivot = arr[high];
	    int i = low-1;
	    
	    for(int j = low; j<high ; j++){
	        if(arr[j] <= pivot){
	            i++;
	            int temp = arr[j];
	            arr[j] = arr[i];
	            arr[i] = temp;
	        }
	        print(arr, low, high);
	    }
	    
	    int temp = arr[i+1];
	    arr[i+1]=arr[high];
	    arr[high] = temp;
	    return i+1;
    }
    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
        	System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    
    public static void print(int[] arr, int a, int b){
        for (int i=a; i<=b; i++){
        	System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
