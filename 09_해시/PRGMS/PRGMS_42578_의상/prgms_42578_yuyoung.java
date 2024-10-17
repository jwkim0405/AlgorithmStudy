import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int combinations = 1;  // 조합의 수
        
        // 의류의 종류, 해당 종류에 속한 의류의 개수 저장
        HashMap<String, Integer> clothesCnt = new HashMap<>();

        // 의류 배열을 순회
        for (String[] item : clothes) {
            String type = item[1]; // 의류의 종류

            // 이미 해당 종류가 해시맵에 있는 경우 : 기존 개수 + 1
            if (clothesCnt.containsKey(type)) {
                clothesCnt.replace(type, clothesCnt.get(type) + 1);
            } else {
                // 없는 경우 : 해당 종류를 해시맵에 추가하고 개수를 1로 설정
                clothesCnt.put(type, 1);
            }
        }

        // 조합의 수
        for (String key : clothesCnt.keySet()) {
        	// 각 종류별 의류의 개수 + 1(아무것도 안입은 선택지)
            combinations *= clothesCnt.get(key) + 1;
        }

        return combinations - 1;  // 모든 종류의 의류를 하나도 안 입는 경우 제외
    }
}