import java.io.*;
import java.util.*;

public class Main {
    static Student[] stdArr;

    static class Student {
        int id;
        List<Student> edgeIn; // 이 학생보다 앞에 서는 학생들
        List<Student> edgeOut; // 이 학생보다 뒤에 서는 학생들

        // 생성자
        public Student(int id) {
            this.id = id;
            this.edgeIn = new ArrayList<>();
            this.edgeOut = new ArrayList<>();
        }

        // 이 학생보다 앞에 서는 학생 추가
        public void addEdgeIn(Student front) {
            this.edgeIn.add(front);
        }

        // 이 학생보다 뒤에 서는 학생 추가
        public void addEdgeOut(Student rear) {
            this.edgeOut.add(rear);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stFirst = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stFirst.nextToken()); // N명의 학생
        int M = Integer.parseInt(stFirst.nextToken()); // M번 키 비교

        stdArr = new Student[N+1];
        // N명 만큼 학생 생성
        for(int i = 1; i <= N; i++) {
            Student std = new Student(i);
            stdArr[i] = std;
        }

        // M번만큼 비교(간선 관계 정의)
        for(int i = 0; i < M; i++) {
            StringTokenizer stTmp = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(stTmp.nextToken());
            int rear = Integer.parseInt(stTmp.nextToken());

            Student first = stdArr[front];
            Student last = stdArr[rear];

            first.addEdgeOut(last); // 앞에 서는 학생에 뒤에 서는 학생 추가(진출차수 증가)
            last.addEdgeIn(first); // 뒤에 서는 학생에 앞에 서는 학생 추가(진입차수 증가)
        }

        // 위상 정렬
        // 1. 진입 차수가 0인 모든 학생을 Queue에 삽입(가장 앞에 서야 하는 학생들)
        Queue<Student> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            Student stdTmp = stdArr[i];
            if(stdTmp.edgeIn.isEmpty()) {
                queue.offer(stdTmp);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 2. Queue가 공백이 될 때까지 반복
        while(!queue.isEmpty()) {
            Student front = queue.poll(); // 가장 먼저 앞에 서게 될 학생
            sb.append(front.id);
            sb.append(" ");

            for(Student st : front.edgeOut) { // a. 모든 뒤에 서는 학생에 대해 간선 제거
                st.edgeIn.remove(front);

                // b. 새롭게 진입차수가 0이 되었다면 queue에 삽입
                if(st.edgeIn.isEmpty()) {
                    queue.offer(st);
                }
            }
        } // 반복 종료(정렬 끝)

        sb.deleteCharAt(sb.length()-1);
        String result = sb.toString();

        System.out.println(result);
        br.close();
    } // main
}
