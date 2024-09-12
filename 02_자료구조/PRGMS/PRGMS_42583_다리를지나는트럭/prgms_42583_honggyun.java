import java.util.*;
import java.io.*;

class Solution {
    class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> wait = new ArrayDeque<>();
        Queue<Truck> cross = new ArrayDeque<>();
        //Queue<Truck> pass = new ArrayDeque<>(); //딱히 필요 없는듯?

        for(int i = 0; i < truck_weights.length; i++) {
            Truck truck = new Truck(truck_weights[i], 0);
            wait.offer(truck);
        } // 대기 트럭 리스트 업

        boolean flag = false;
        int time = 0;
        int crossSum = 0;
        // 모든 트럭이 다리를 지날 때까지
        while(!wait.isEmpty() || !cross.isEmpty()) {
            time++;

            // 다리 건너는 것 처리
            if(!cross.isEmpty()
                    && cross.peek().time + bridge_length == time) {
                Truck truck = cross.poll();

                time = truck.time + bridge_length;
                crossSum -= truck.weight;
            }

            // 대기 트럭 처리           
            // 다리를 건널 수 있는 조건이 만족 되면
            // 1. 무게가 넘지 않고
            // 2. 대수가 넘지 않을 때
            if(!wait.isEmpty()
                    && crossSum + wait.peek().weight <= weight
                    && cross.size() + 1 <= bridge_length) {

                Truck truck = wait.poll();
                truck.time = time; // 시간               

                cross.offer(truck);
                crossSum += truck.weight; // 다리를 건너는 트럭 무게           
            } // 대기 트럭 처리 끝                       


        }

        int answer = time;
        return answer;
    }
}