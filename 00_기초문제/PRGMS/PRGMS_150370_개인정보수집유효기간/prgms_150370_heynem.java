import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<terms.length; i++){
            if(terms[i].length()==3){
                map.put(terms[i].charAt(0), terms[i].charAt(2)-'0');
            } else {
                int tmp = 0;
                for(int j = 2; j<terms[i].length(); j++){
                    tmp = tmp*10+terms[i].charAt(j)-'0';
                }
                map.put(terms[i].charAt(0), tmp);
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<privacies.length; i++){
            String privacy = privacies[i];
            int last = map.get(privacy.charAt(11));
            int distanceMonth = ((today.charAt(2)-privacy.charAt(2))*10+today.charAt(3)-privacy.charAt(3))*12+((today.charAt(5)-privacy.charAt(5))*10+today.charAt(6)-privacy.charAt(6));
            if(last==distanceMonth){
                if((today.charAt(8)-privacy.charAt(8))*10+today.charAt(9)-privacy.charAt(9)>=0){
                    list.add(i+1);
                }
            }else if(last<distanceMonth) {
                list.add(i+1);
            } 
            
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}
