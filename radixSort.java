import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int[] a = {4533,323,4124,544,4345,4656,435,4766};
	    int[] b = radixSort(a);
		print(b);
	}
	public static int[] radixSort(int[] arr){
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
    
        // Process digits from LSD → MSD
        for (int exp = 1; max / exp > 0; exp *= 10) {
    
            // Step 1: Create buckets (0–9)
            List<Integer>[] buckets = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                buckets[i] = new ArrayList<>();
            }
    
            // Step 2: Place elements into buckets
            for (int i = 0; i < arr.length; i++) {
                int digit = (arr[i] / exp) % 10;
                buckets[digit].add(arr[i]);
            }
    
            // Step 3: Collect back into array (IMPORTANT: preserves order → stable)
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int num : buckets[i]) {
                    arr[index++] = num;
                }
            }
        }
    
        return arr;
    }
    // Not Preserving previous digits sorting logic
	public static int[] radixSortOld(int[] arr){
	    List<Integer>[] arrayOfDigits = new ArrayList[arr.length];
	    List<Integer>[] arrayOfDigitsSorted = new ArrayList[arr.length];
	    
	    for (int i = 0; i < arr.length; i++) {
            arrayOfDigits[i] = new ArrayList<>();
        }
	    
	    for(int i = 0 ; i < arr.length ; i++){
	        // String num = Integer.parseInt(arr[i]);
	        char[] charArray = ("" + arr[i]).toCharArray();
	        int[] intArray = convert(charArray);
	        for (int j = 0; j < intArray.length; j++) {
                arrayOfDigits[i].add(intArray[j]);
            }
	    }
	    
	    for(int j = arrayOfDigits[0].size()-1 ; j > -1 ; j--){
	        for(int i = 1 ; i < arrayOfDigits.length ; i++){
                while(arrayOfDigits[i].get(j)<arrayOfDigits[i-1].get(j)){
                    List<Integer> temp = arrayOfDigits[i];
                    arrayOfDigits[i] = arrayOfDigits[i-1];
                    arrayOfDigits[i-1] = temp;
                }
	        }
	    }
	    
	    for (int i = 0; i < arrayOfDigits.length; i++) {
            int num = 0;
            for (int digit : arrayOfDigits[i]) {
                num = num * 10 + digit;
            }
            arr[i] = num;
        }
        return arr;
    }
    public static int[] convert(char[] arr){
        int[] res = new int[arr.length];
        for (int  i = 0; i<arr.length; i++) {
        	res[i] = Character.getNumericValue(arr[i]);
        }
        return res;
    }
    public static void print(int[] arr){
        for (int num : arr) {
        	System.out.print(num + ", ");
        }
        System.out.println();
    }
}
