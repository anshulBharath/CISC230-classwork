package week09;

public class BubbleSort {

	public static void main(String[] args) {
		int[] list = {1,7,3,2,4};
		
		System.out.println(printArray(list));
		bubbleSort2(list);
		System.out.println(printArray(list));

	}
	
	private static void bubbleSort(int[] list) {
		int temp; 
		
		for(int i = 0; i <= list.length; i++) {
			if(list[i] > list[i + 1]) {
				temp = list[i];
				list [i] = list[i + 1];
				list[i + 1] = temp;
			}
		}
	}
	
	private static void bubbleSort2(int[] arr) {
		int n = arr.length;  
        int temp = 0;
        
        for(int i=0; i < n; i++){  
        	for(int j=1; j < (n-i); j++){  
        		if(arr[j-1] > arr[j]){  
                                 //swap elements  
        			temp = arr[j-1];  
        			arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }  
                          
             }
        }
	}
	
	private static String printArray(int[] array) {
		String ret = "";
		
		for(int i = 0; i < array.length; i++) {
			ret = ret + array[i] + ", ";
		}
		return ret;
	}

}
