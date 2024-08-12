import java.util.Arrays;
import java.util.Scanner;

public class boj_14696_huiju {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			
			int aNum = sc.nextInt();	//a가 가진 그림의 총 개수
			int[] aArr = new int[aNum];	//a 그림을 저장하는 배열 생성
			
			for(int a=0; a<aArr.length; a++) {	//a 그림을 배열에 저장
				aArr[a] = sc.nextInt();
			}
			Arrays.sort(aArr);
			aArr = reverseSort(aArr);
			
			int bNum = sc.nextInt();	//b가 가진 그림의 총 개수
			int[] bArr = new int[bNum];	//b 그림을 저장하는 배열 생성
			
			for(int b=0; b<bArr.length; b++) {	//b 그림을 배열에 저장
				bArr[b] = sc.nextInt();
			}
			Arrays.sort(bArr);
			bArr = reverseSort(bArr);
			//---------------------------------------------------

			int len = aArr.length <bArr.length ? aArr.length : bArr.length ;	//길이가 더 짧은 쪽을 기준으로 비교하기 위한 변수

			out : for(;;) {
				
				for(int j=0; j<len; j++) {
					if(aArr[j] > bArr[j]) {
						System.out.println('A');
						break out;
					}else if(bArr[j] > aArr[j]) {
						System.out.println('B');
						break out;
					}
				}
				if(aArr.length > bArr.length) {
					System.out.println('A');
					break;
				}else if(aArr.length < bArr.length){
					System.out.println('B');
					break;

				}else {
					System.out.println('D');
					break;
				}
			}
		}
	}


	static int[] reverseSort(int[] arr) {
		int[] tmp = new int[arr.length];
		for(int j=0; j<arr.length; j++) {
			tmp[arr.length-j-1] = arr[j];
		}
		return tmp;
	}

}
