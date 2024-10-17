import java.util.*;


/* NEW! */
/*
map.containsKey()
map.keySet() Return a set of all keys in the map 	Set<K>
*/
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, List<String>> map = new HashMap<>();

        // for all elements, put in map
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String category = cloth[1];

            // if category doesn't exist -> add new category as a key
            if(!map.containsKey(category)) {
                List<String> clothNames = new ArrayList<>();
                clothNames.add(name);
                map.put(category, clothNames);
            } else { // if category exists -> add value with the category(arrayList.add())
                List<String> clothNames = map.get(category);
                clothNames.add(name); // 얕은 복사일까? 깊은 복사일까? 얕은 복사면 add한 순간 끝내도 됨
                // -> 얕은 복사임! map에서 참조하고 있는 참조값을 clothNames라는 객체에 할당하는 형식!
                // 따라서, 자동으로 업데이트 된다!                
            }
        } // saved

        // combination -> at most 1 for each category.
        int combination = 1;
        // 1. check how many categories are in
        List<String> clothCategories = new ArrayList<>(map.keySet());
        // 2. count numbers of clothes of each categories
        for(String clothCategory : clothCategories) {
            List<String> clothNames = map.get(clothCategory);
            combination *= (clothNames.size() + 1); // not wearing -> just +1 option 
        }

        answer = combination - 1; // subtract the case of all not wearing
        return answer;
    }
}