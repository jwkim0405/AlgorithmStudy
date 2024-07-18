import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static int max4(int n1, int n2, int n3, int n4){
        int max = -9999;
        int[] array = {n1, n2, n3, n4};
        for (int i = 0; i < 4; i++){
            if (max<array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public static void SWEA1206_hyenem(String[] args) {
         Scanner sc = new Scanner(System.in);
        for (int T = 1 ; T < 11; T++){
            int buildingNum = sc.nextInt();
            int[] buildingHight = new int[buildingNum];
            int ans = 0;
            
            for (int i = 0; i < buildingNum; i++){
                buildingHight[i] = sc.nextInt();
            }
            
            for (int i = 2; i < buildingNum-2; i++){
                int adj = max4(buildingHight[i-2], buildingHight[i-1],  buildingHight[i+1], buildingHight[i+2]);
                if (buildingHight[i]>adj){
                    ans += buildingHight[i] - adj;
                    i +=2;
                }

            }


            System.out.printf("#%d %d\n", T, ans);
        }
	}
}
