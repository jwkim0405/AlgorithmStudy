import java.util.Arrays;
import java.util.Scanner;

public class Boj_2529_hyenem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = new char[N];
		for (int i = 0; i<N; i++) {
			arr[i]=sc.next().charAt(0);
		}
		
		int[] localMax = new int[N];
		int pointerMax = 0;
		int[] localMin = new int[N];
		int pointerMin = 0;
		
		if (arr[0]=='<') {
			pointerMin++;
		} else {
			pointerMax++;
		}
		for(int i = 1; i<N; i++) {
			if (arr[i-1]=='>' && arr[i]=='<') {
				localMin[pointerMin++] = i;
			} else if (arr[i-1]=='<' && arr[i]=='>') {
				localMax[pointerMax++]=i;
			}
		}
		if (arr[N-1]=='<') {
			localMax[pointerMax]=N;
			pointerMax++;
		} else {
			localMin[pointerMin]=N;
			pointerMin++;
		}
		

		int[] MaxArr = new int[N+1];
		int[] MinArr = new int[N+1];
		
		//최대 찾기
		int num = 9;
		while(num>=9-N) {
			for (int i = 0; i<pointerMax; i++) {
				
				MaxArr[localMax[i]]=num--;
				
				for (int j = localMax[i]; j>=0; j--) {
					if (j-1==-1) break;
					if (arr[j-1]!='<') break;
					MaxArr[j-1]=num--;
					if(num<9-N) break;
				}
				
				if(num<9-N) break;
				
				for (int j = localMax[i]; j<N; j++) {
					if (num==9-N-1) break;
					if (arr[j]!='>') break;
					if (j+1==N || arr[j+1]=='>') {
						MaxArr[j+1]=num--;						
					} else {
						break;
					}
					if(num<9-N) break;
				}
			}
		}
		for (int i = 0; i<N+1; i++) {
			System.out.print(MaxArr[i]);
		}
		System.out.println();
		
		
		//최소 찾기
		num = 0;
		while(num<=N) {
			for (int i = 0; i<pointerMin; i++) {
				
				MinArr[localMin[i]]=num++;
				
				for (int j = localMin[i]; j>=0; j--) {
					if (j-1==-1) break;
					if (arr[j-1]!='>') break;
					MinArr[j-1]=num++;
					if(num>N) break;
				}
				
				if(num>N) break;
				
				for (int j = localMin[i]; j<N; j++) {
					if (num>N) break;
					if (arr[j]!='<') break;
					if (j+1==N || arr[j+1]=='<') {
						MinArr[j+1]=num++;						
					} else {
						break;
					}
					if(num>N) break;
				}
			}
		}

		for (int i = 0; i<N+1; i++) {
			System.out.print(MinArr[i]);
		}
	}
}

