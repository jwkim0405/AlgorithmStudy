class Solution {
    public int[] solution(String[][] places) {
        // 각 대기실의 거리두기 준수 여부를 저장할 배열
        int[] answer = new int[places.length];
        
        // 각 대기실을 순회하며 거리두기 준수 여부 확인
        for (int i = 0; i < places.length; i++) {
            boolean isSafe = true;  // 대기실이 안전한지 여부를 체크하는 변수
            
            // 5x5 대기실의 모든 좌표를 순차적으로 확인
            // 'outerLoop'는 중첩된 반복문을 한 번에 빠져나오기 위한 레이블
            outerLoop:
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    // 해당 좌표에 응시자가 앉아있는 경우 ('P'인 경우)
                    if (places[i][r].charAt(c) == 'P') {
                        
                        // 맨해튼 거리 1인 좌표(상하좌우) 확인
                        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                        for (int[] d : directions) {
                            int nr = r + d[0], nc = c + d[1];
                            // 좌표가 유효하고, 그 위치에 다른 응시자가 있으면 거리두기 위반
                            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && places[i][nr].charAt(nc) == 'P') {
                                isSafe = false;  // 안전하지 않음
                                // outerLoop를 사용하여 모든 반복문을 한 번에 빠져나감
                                break outerLoop;
                            }
                        }
                        
                        // 맨해튼 거리 2인 좌표(2칸 떨어진 곳) 확인
                        int[][] farDirections = {{0, 2}, {2, 0}, {0, -2}, {-2, 0}};
                        for (int[] d : farDirections) {
                            int nr = r + d[0], nc = c + d[1];
                            // 좌표가 유효하고, 그 위치에 다른 응시자가 있는 경우 중간에 파티션('X')이 있어야 함
                            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && places[i][nr].charAt(nc) == 'P') {
                                if (places[i][r + d[0] / 2].charAt(c + d[1] / 2) != 'X') {
                                    isSafe = false;  // 파티션이 없으면 거리두기 위반
                                    // outerLoop를 사용하여 즉시 종료
                                    break outerLoop;
                                }
                            }
                        }
                        
                        // 대각선에 있는 경우(맨해튼 거리 2) 확인
                        int[][] diagonalDirections = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
                        for (int[] d : diagonalDirections) {
                            int nr = r + d[0], nc = c + d[1];
                            // 좌표가 유효하고, 그 위치에 다른 응시자가 있는 경우 양쪽에 파티션이 있어야 함
                            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && places[i][nr].charAt(nc) == 'P') {
                                if (!(places[i][r].charAt(nc) == 'X' && places[i][nr].charAt(c) == 'X')) {
                                    isSafe = false;  // 파티션이 양쪽에 없으면 거리두기 위반
                                    // outerLoop를 사용하여 즉시 종료
                                    break outerLoop;
                                }
                            }
                        }
                    }
                }
            }
            
            // 현재 대기실이 안전하면 1, 그렇지 않으면 0을 저장
            answer[i] = isSafe ? 1 : 0;
        }
        
        return answer;  // 모든 대기실의 거리두기 준수 여부를 반환
    }
}
