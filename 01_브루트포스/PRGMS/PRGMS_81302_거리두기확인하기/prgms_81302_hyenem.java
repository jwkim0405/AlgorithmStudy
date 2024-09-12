class Solution {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int tc = 0; tc<5; tc++){
            char[][] arr = new char[5][5];
            for(int i = 0; i<5; i++){
                for(int j = 0; j<5; j++){
                    arr[i][j]=places[tc][i].charAt(j);
                }
            }
            
            int ans = 1;
            end: for(int i = 0; i<5; i++){
                for(int j = 0; j<5; j++){
                    if(arr[i][j]=='P'){
                        for(int k = 0; k<4; k++){
                            int x = i+dx[k];
                            int y = j+dy[k];
                            if(x>=0 && x<5 && y>=0 && y<5){
                                if(arr[x][y]=='P') {
                                    ans = 0;
                                    break end;
                                }
                                else if(arr[x][y]=='O'){
                                    for(int nk = 0; nk<4; nk++){
                                        int nx = x+dx[nk];
                                        int ny = y+dy[nk];
                                        if(nx==i && ny==j) continue;
                                        if(nx>=0 && nx<5 && ny>=0 && ny<5){
                                            if(arr[nx][ny]=='P') {
                                                ans = 0;
                                                break end;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            answer[tc]=ans;
        }//tc
        return answer;
    }
}
