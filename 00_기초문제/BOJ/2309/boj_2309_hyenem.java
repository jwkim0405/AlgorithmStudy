package boj_2309;


	import java.util.Scanner;

	public class Main{
	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int[] arr = new int[9];
	        int sum =0;
	        for (int i =0; i<9; i++){
	            arr[i]=sc.nextInt();
	            sum+=arr[i];
	        }
	        
	        int[] newarr = countingSort(arr);
	        int x=0;
	        int y=0;
	        end:for (int i = 0; i<8; i++) {
	        	for (int j = i+1; j<9; j++) {
	        		if(newarr[i]+newarr[j]==sum-100) {
	        			x=i;
	        			y=j;
	        			break end;
	        		}
	        	}
	        }
	        
	        for (int i=0; i<9; i++) {
	        	if(i!=x && i!=y) {
	        		System.out.println(newarr[i]);
	        	}
	        }
	    }
	    
	    static int[] countingSort(int[] arr){
	        int[] count = new int[100];
	        int[] acc = new int[100];
	        int[] newarr = new int[arr.length];
	        
	        for(int i = 0; i<arr.length; i++){
	            count[arr[i]]++;
	        }
	        acc[0] = count[0];
	        for (int i = 1; i<100; i++){
	            acc[i]=acc[i-1]+count[i];
	        }
	        
	        for (int i = arr.length-1; i>=0; i--){
	            newarr[--acc[arr[i]]] = arr[i];
	        }
	        
	        return newarr;
	    }
	}

