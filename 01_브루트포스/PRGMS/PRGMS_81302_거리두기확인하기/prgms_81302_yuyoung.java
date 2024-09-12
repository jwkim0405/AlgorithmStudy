import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];

            boolean isOk = true;  // 거리두기가 지켜졌는지 여부

            for (int r = 0; r < 5 && isOk; r++) {
                for (int c = 0; c < 5 && isOk; c++) {
                    // 만약 사람이 있는 위치라면 BFS
                    if (p[r].charAt(c) == 'P') {
                        if (!bfs(r, c, p))
                            isOk = false;
                    }
                }
            }
            if (isOk) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private static boolean bfs(int r, int c, String[] p) {
        int dr[] = { -1, 1, 0, 0 };
        int dc[] = { 0, 0, -1, 1 };

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] { r, c });  // 현재 사람의 위치를 큐에 추가

        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = position[0] + dr[i];
                int nc = position[1] + dc[i];

                // 범위 밖이거나 시작점인 경우
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
                    continue;

                int d = Math.abs(nr - r) + Math.abs(nc - c);  // 맨해튼 거리

                // 맨해튼 거리가 2 이하이고 다른 사람이 있으면
                if (p[nr].charAt(nc) == 'P' && d <= 2)
                    return false;
                // 빈 테이블이고 거리가 2 미만인 경우, 탐색을 계속 진행
                else if (p[nr].charAt(nc) == 'O' && d < 2)
                    q.offer(new int[] { nr, nc });
            }
        }

        return true;
    }
}
