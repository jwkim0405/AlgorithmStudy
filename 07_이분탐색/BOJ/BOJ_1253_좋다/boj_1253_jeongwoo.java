import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> numArr;
    static int findNum; // '좋다'가 되기 위해 나와야하는 num2값
    static int cnt; // '좋다' 개수
    static int N; // 숫자 개수
    static boolean isCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 숫자 개수
        numArr = new ArrayList<>();
        cnt = 0; // '좋다' 개수
        // 숫자 입력
        for (int i = 0; i < N; i++) {
            numArr.add(sc.nextInt());
        }
        Collections.sort(numArr);
        
        // i번째 값이 있는지 확인
       NEXT: for (int i = 0; i < N; i++) {
            if (i == 0 && N >= 3) {
                if (numArr.get(0) < numArr.get(1) + numArr.get(2)) continue NEXT;
            } else if (i == N-1 && N >= 3) {
                if (numArr.get(N-1) > numArr.get(N-2) + numArr.get(N-3)) break;
            }

            int iVal = numArr.get(i);
            numArr.remove(i); // 배열에서 i 인덱스 값 삭제

            // 0번째 값부터 num1은 fix해놓기
            for (int num1 = 0; num1 < N-2; num1++) {
                // 남은 배열에서 findNum이 존재하는지 이분탐색 진행
                int num1Val = numArr.get(num1);
                findNum = iVal - num1Val; // 찾아야 하는 num2의 값
                binarySearch(num1+1, N-2); // index i를 삭제 => 마지막 index: N-2
                if(isCnt) break;
            } // for num1
            numArr.add(i, iVal); // 다시 i 배열에 넣기
            isCnt = false;
        } // for i

        System.out.println(cnt);
    } // main

    static void binarySearch(int left, int right) {
        while(left <= right) {
            if (isCnt) return;
            int mid = (left + right) / 2;

            // num2값이 일치하는 게 있다면!
            if (numArr.get(mid) == findNum) {
                isCnt = true;
                cnt++;
                return;
            }
            // 더 큰 값을 봐야 할 때 !
            else if (numArr.get(mid) < findNum) {
                left = mid + 1;
                binarySearch(left, right);
            }
            // 더 작은 값을 봐야 할 때!
            else {
                right = mid - 1;
                binarySearch(left, right);
            }
        }
    }
} // class

