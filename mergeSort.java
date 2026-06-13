public class Main
{
    static void merge(int[] arr, int first, int mid, int last){
    	int[] resArray = new int[last-first+1];
    	// Conquering the sorting of elements from both arrays
    	int n1 = mid-first+1;
    	int n2 = last-mid;
    	
    	// Creating separate arrays for both ends (left and right)
    	
    	int[] arr1 = new int[n1];
    	int[] arr2 = new int[n2];
    	
    	// store elements
    	for (int i = 0; i < n1; i++){
    	    arr1[i]=arr[first+i];
    	}
    	for (int i = 0; i < n2; i++){
    	    arr2[i]=arr[mid+1+i];
    	}
    	
    	// compare and copy to resArray
    	
    	int count = 0;
    	int i = 0;
    	int j = 0;
    	
    	while(i<n1 && j<n2){
    		if (arr1[i] > arr2[j]){
    			resArray[count++] = arr2[j++];
    		}
    		else{
    			resArray[count++] = arr1[i++];
    		}
    	}
    	
    	// copy remaining elements from either of the array.
    	
    	while(i<n1){
    	    resArray[count++] = arr1[i++];
    	}
    	
    	while(j<n2){
    	    resArray[count++] = arr2[j++];
    	}
    	
    	// copy back to original array.
    	for (int k = 0; k < resArray.length; k++) {
            arr[first + k] = resArray[k];
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
