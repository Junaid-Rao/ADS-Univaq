public class Main
{
	public static void main(String[] args) {
	    int[] a = {43,5,12,54,12,1,65,76};
	    int[] b = insertionSort(a);
		print(b);
	}
	public static int[] insertionSort(int[] arr){
	    int innercomparisions = 0; 
	    int outercomparisions = 0; 
        for (int i = 1;i<arr.length;i++){
            int j = i-1;
            int k = i;
            outercomparisions++;
            while(j>=0 && arr[k]<arr[j]){
                int temp = arr[k];
                arr[k--] = arr[j];
                arr[j--] = temp;
                innercomparisions++;
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
