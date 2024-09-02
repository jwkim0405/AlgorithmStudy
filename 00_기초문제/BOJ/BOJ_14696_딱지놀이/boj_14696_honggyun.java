import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 라운드 총 개수
        for(int round = 1; round <= N; round++) {
            int[] countArrA = new int[5]; // 카운팅 배열
            // a가 내는 그림 카운트
            int a = sc.nextInt();
            for(int i = 0; i < a; i++) {
                int value = sc.nextInt();
                countArrA[value]++;
            }


            // b도 해주기
            int[] countArrB = new int[5];
            int b = sc.nextInt();
            for(int j = 0; j < b; j++) {
                int value = sc.nextInt();
                countArrB[value]++;
            }

            // 내림차순 정렬
            reverseSort(countArrA);
            reverseSort(countArrB);

            String result = "";
            for(int i = 0; i < 4; i++) {
                // 같으면
                if(countArrA[i] == countArrB[i]) {
                    if(i == 3) result = "D"; // 마지막에도 같으면 Draw
                }
                else { // 다르면
                    if(countArrA[i] > countArrB[i]) {
                        result = "A"; // A가 더 크면 A win
                        break;
                    } else {
                        result = "B"; // B가 더 크면 B win
                        break;
                    }
                }

            }

            System.out.println(result);
        }
    }

    public static void reverseSort(int[] arr) {
        for(int i = 0; i < arr.length/2; i++) { // 절반만 순회하면서 바꿔주면 됨
            int tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }
    }

}