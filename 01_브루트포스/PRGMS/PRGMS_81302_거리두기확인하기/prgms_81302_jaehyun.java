class Solution {
    public int[] solution(String[][] places) {
        // 각 대기실의 거리두기 준수 여부를 저장할 배열
        int[] answer = new int[places.length];
        
        // 각 대기실을 순회
        for (int i = 0; i < places.length; i++) {
            boolean isSafe = true;  // 대기실이 안전한지 여부 확인용 변수
            
            // 대기실의 각 좌표를 확인 (5x5 대기실)
            outerLoop:
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    // 만약 해당 좌표에 응시자가 앉아있는 경우('P')
                    if (places[i][r].charAt(c) == 'P') {
                        // 맨해튼 거리 1인 경우 상하좌우 확인
                        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                        
                        for (int[] d : directions) {
                            int nr = r + d[0], nc = c + d[1];
                            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && places[i][nr].charAt(nc) == 'P') {
                                isSafe = false;  // 거리두기를 지키지 않음
                                break outerLoop; // 더 이상 확인할 필요가 없으므로 전체 반복문 종료
                            }
                        }
                        
                        // 맨해튼 거리 2인 경우 확인 (2칸 떨어진 좌표)
                        int[][] farDirections = {{0, 2}, {2, 0}, {0, -2}, {-2, 0}};
                        
                        for (int[] d : farDirections) {
                            int nr = r + d[0], nc = c + d[1];
                            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && places[i][nr].charAt(nc) == 'P') {
                                if (places[i][r + d[0] / 2].charAt(c + d[1] / 2) != 'X') {
                                    isSafe = false;
                                    break outerLoop; // 거리두기 위반 시 반복 종료
                                }
                            }
                        }
                        
                        // 대각선에 있는 경우도 확인
                        int[][] diagonalDirections = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
                        
                        for (int[] d : diagonalDirections) {
                            int nr = r + d[0], nc = c + d[1];
                            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && places[i][nr].charAt(nc) == 'P') {
                                if (!(places[i][r].charAt(nc) == 'X' && places[i][nr].charAt(c) == 'X')) {
                                    isSafe = false;
                                    break outerLoop; // 위반 시 바로 종료
                                }
                            }
                        }
                    }
                }
            }
            
            // 현재 대기실이 안전하면 1, 아니면 0을 저장
            answer[i] = isSafe ? 1 : 0;
        }
        
        return answer;  // 모든 대기실의 거리두기 준수 여부 반환
    }
}
