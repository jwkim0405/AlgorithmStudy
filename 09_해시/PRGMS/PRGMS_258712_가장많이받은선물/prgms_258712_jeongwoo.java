import java.util.*;

class Solution {
    static int[][] cnt; // a가 b한테 준 선물 갯수
    static int[] index; // 각 인덱스 값이 주고(+)받은(-) 선물의 합
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        // 이름별 인덱스 매핑
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(friends[i], i);
        }
        
        cnt = new int[N][N]; // cnt[a][b] -> a가 b한테 준 선물 갯수
        index = new int[N];
        
        // gifts split함수로 자르기
        for (int i = 0; i < gifts.length; i++) {
            String[] fromTo = gifts[i].split(" ");
            int from = map.get(fromTo[0]);
            int to = map.get(fromTo[1]);
            index[from]++;
            index[to]--;
            
            cnt[from][to]++;
        }
        
        int[] totalCnt = new int[N]; 
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                // i가 j한테 더 많이 줬다면
                if (cnt[i][j] > cnt[j][i]) totalCnt[i]++;
                // j가 i한테 더 많이 줬다면
                else if (cnt[i][j] < cnt[j][i]) totalCnt[j]++;
                // i와 j가 나눈 개수가 같다면
                else {
                    // // 두 사람의 선물 지수
                    // int iSum = 0;
                    // int jSum = 0;
                    // for (int k = 0; k < N; k++) {
                    //     iSum += (cnt[i][k]-cnt[k][i]);
                    //     jSum += (cnt[j][k]-cnt[k][j]);
                    // }
                    // // 선물지수가 높은 사람이 선물을 받음
                    // if (iSum > jSum) totalCnt[i]++;
                    // else if (iSum < jSum) totalCnt[j]++;
                    
                    if(index[i] > index[j]) totalCnt[i]++;
                    else if(index[i] < index[j]) totalCnt[j]++;
                }
            }
        }
        int maxGift = 0;
        for(int cnt: totalCnt) {
            System.out.print(cnt);
            maxGift = Math.max(cnt, maxGift); // 최대값 업데이트
        }
        
        return maxGift;
    }
}
