import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//주어진 채널을 String[]과 int로 저장
		//for문 : 고장난 버튼 수만큼 반복
		//내부for문 : 채널 자릿수만큼 반복하며 고장난 버튼과 일치하는 버튼이 있는지 탐색
		//고장난 번호를 가고 싶은 채널에서 가장 가까운 버튼으로 바꿈
		//가능한 경우의 채널 수들을 String tmp에 저장하고 int로 형변환
		//[저장된 채널번호 - 가고싶은 채널 번호를 뺀 후의 절댓값 + 채널 길이]가 답이 된다
		
		Scanner sc = new Scanner(System.in);
		int channelInt = sc.nextInt();	//채널을 int으로 저장
		String[] channelStr = (channelInt+"").split("");	//channelInt를 String[]으로 저장
		int num = sc.nextInt();	//고장난 버튼 수를 num으로 저장
		String tmp = "";
		int result;
		
		for(int i=0; i<num; i++) {	//고장난 버튼 수만큼 반복
			if(channelInt ==100) {	//가고싶은 채널이 100번일 경우 탈출
				System.out.println(0);	//0을 반환 후
				return;	//main메서드 종료
			}	
			int trouble = sc.nextInt();	//고장난 버튼을 int로 받음
			for(int j=0; j<channelStr.length; j++) {	//채널 자릿수만큼 반복 **예제6 문제발생**
				if(trouble == (Integer.parseInt(channelStr[j]))) {	//고장난 버튼과 같은 채널번호를 발견하면
					
					if(trouble ==9) {channelStr[j] = "8";}	//고장난 번호가 9면 8, 0이면 1로 바꿈
					else if(trouble ==0) {channelStr[j] = "1";}
					//그외 전부 channelStr의 해당 자리를 고장난버튼+1의 수로 바꾼다
					else {channelStr[j] = trouble+1+"";}
				}
			}
		}
		//고장나지 않은 번호로 다 바꿨다. 이제 Math.abs로 절대값 구하기
		for(int i=0; i<channelStr.length; i++) {	//result에 배열값 합치기
			tmp +=channelStr[i];
//			System.out.println(tmp);
		}
		//[저장된 채널번호 - 가고싶은 채널 번호를 뺀 후의 절댓값 + 채널 길이]
		result = Math.abs(Integer.parseInt(tmp) - channelInt)+channelStr.length;
		System.out.println(result);
	}

}


//예제 6번 7번이 이상함