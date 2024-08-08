import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Character> queue = new LinkedList<>();
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words = sc.next(); // 단어 받아오기		
		
		for(int i = 0; i < words.length(); i++) {
			char alphabet = words.charAt(i); // 알파벳 한 글자
			
			countCroatiaAlphabet(alphabet);
			
			if(i == words.length() - 1 && !queue.isEmpty()) { 
				queue.remove();
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	
	
	static void countCroatiaAlphabet(char alphabet) {		
		if(queue.isEmpty()) {						
			if(alphabet == 'c'  // 크로아티아 알파벳의 가능성을 가진 알파벳들이 온 경우
					|| alphabet == 'd' 
					|| alphabet == 'l' 
					|| alphabet == 'n' 
					|| alphabet == 's' 
					|| alphabet == 'z') {

					queue.offer(alphabet); // 큐에 넣는다
				} else {
//					System.out.println("1번 증가하기전 cnt = " + cnt + "이고, 알파벳은 " + alphabet + "입니다.");
					cnt++; // 그냥 평범한 알파벳이 온 경우
				}			
		} else if(!queue.isEmpty()) { // 큐가 비어있지 않으면
			char before = queue.poll(); // 그 전에 있던 Croatiable Alphabet poll			
			// 얘네들이면
			if(alphabet == '='
				|| alphabet == '-'
				|| alphabet == 'j') {
				
				if(!queue.isEmpty()) { // 쟤네들인데 큐가 비어있지않으면 dz= 경우 
					queue.remove();	// 하나 더 뽑아서 비워줌
				}								
				
//				System.out.println("2번 증가하기전 cnt = " + cnt + "이고, 알파벳은 " + alphabet + "입니다.");
				cnt++; // 크로아티아 알파벳 1개 완성!				
			} else if(before == 'd' && alphabet == 'z') { 
				queue.offer(before);
				queue.offer(alphabet);
			} else if(alphabet != 'c'
					&& alphabet != 'd' 
					&& alphabet != 'l' 
					&& alphabet != 'n' 
					&& alphabet != 's' 
					&& alphabet != 'z'){ // 크로아티아 알파벳이 아니었다!				
//				System.out.println("3번 증가하기전 cnt = " + cnt + "이고, 알파벳은 " + alphabet + "입니다.");
				cnt += 2; // 별개의 알파벳 2개 였다!
			} else { // c d l n s z가 한 번 더 왔을 때
//				System.out.println("4번 증가하기전 cnt = " + cnt + "이고, 알파벳은 " + alphabet + "입니다.");
				cnt++;
				queue.offer(alphabet); // 큐에 넣는다
			}
			
		} 
	}

}
