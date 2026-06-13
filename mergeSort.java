public class Main
{
    static void merge(int[] arr, int first, int mid, int last){
    	int[] resArray = new int[last-first+1];
    	// Conquering the sorting of elements from both arrays
    	int i = first;
    	int j = mid+1;
		int k = 0;
    	
    	// compare and copy to resArray
    	
    	while(i<=mid && j<=last){
    		if (arr[i] >= arr[j]){
    			resArray[k++] = arr[j++];
    		}
    		else{
    			resArray[k++] = arr[i++];
    		}
    	}
    	
    	// copy remaining elements from either of the array.
    	
    	while(i<=mid){
    	    resArray[k++] = arr[i++];
    	}
    	
    	while(j<=last){
    	    resArray[k++] = arr[j++];
    	}
    	
    	// copy back to original array.
    	for (int x = 0; x < resArray.length; x++) {
            arr[first + x] = resArray[x];
        }
    }

    static void mergeSort(int[] arr, int first, int last){
    	if(first >= last){
    		return;
    	}
    	int mid = (first+last)/2;
    	mergeSort(arr, first, mid);
    	mergeSort(arr, mid+1, last);
    	merge(arr, first, mid, last);
    }
    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
        	System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
	public static void main(String[] args) {
	    int[] a = {45,5,42,34,32,31,27,26};
	    mergeSort(a,0,a.length - 1);
		print(a);
	}
}
