import java.util.Scanner;

public class boj_10158_huiju_시간초과 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int x = sc.nextInt();	//개미의 초기위치
		int y = sc.nextInt();
		int time = sc.nextInt();	//개미가 움직이는 시간
		int[] dx = {1, 1, -1, -1};	//델타배열 - 우하 우상 좌상 좌하 
		int[] dy = {-1, 1, 1, -1};
		int idx = 1;
		
		//----------------------------------
		
		for(int i=0; i<time; i++) {	//개미가 움직이는 시간만큼 반복한다

			//일단 개미의 초기위치인덱스에 우상 델타배열을 더해줌
			x += dx[idx];
			y += dy[idx];
			
			//만약 진로가 배열을 벗어나는 경우
			if(x < 0 || y < 0 || x > w || y > h) {
				x -= dx[idx];	//더해줬던 걸 다시 빼줌
				y -= dy[idx];
				
					//현재 델타배열의 좌우를 살핀다
					int idx1 = (idx+1) % 4;	//우
					int idx2 = (idx+3) % 4;	//좌
					
					//우측 델타배열을 적용했을 때 배열의 범위를 벗어나지 않으면
					if(x + dx[idx1] >= 0 && y + dy[idx1] >= 0 				
							&& x + dx[idx1] <= w && y + dy[idx1] <= h) {	
						
						idx = idx1;		//해당 델타배열의 인덱스를 원본인덱스에 저장
						
						//우측 델타배열을 적용했을 때 배열의 범위를 벗어나지 않으면
					}else if(x + dx[idx2] >= 0 && y + dy[idx2] >= 0 
							&& x + dx[idx2] <= w && y + dy[idx2] <= h) {
						
						idx = idx2;		//해당 델타배열의 인덱스를 원본인덱스에 저장
						
					}else {		//위의 두 케이스 다 벗어나면(꼭짓점일 경우)왔던 위치로 되돌아가기
						idx = (idx+2) % 4;
						}
					
					x += dx[idx];	//배열을 벗어나지 않는 델타배열을 더해준다
					y += dy[idx];
			}
		}
		System.out.printf("%d %d\n", x, y);
		
		
		
	}

}
