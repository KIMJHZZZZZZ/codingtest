import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[104];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < speeds.length; i++){
        	int num = 100 - progresses[i];
        	int count = num / speeds[i];
        	if(num % speeds[i] > 0) count++;
        	list.add(count);
        }
        
        int start = list.get(0);
        int idx = 0, cnt = 1;
        for(int i = 1; i < list.size(); i++){
        	if(start < list.get(i)){
        		start = list.get(i);
        		answer[idx++] = cnt;
        		cnt = 0;
        	}	
        	cnt++;
        }
        answer[idx] = cnt;
		
		List<Integer> ret = new ArrayList<>();
		
		for(int i = 0; i < 104; i++){
			if(answer[i] > 0) ret.add(answer[i]);
		}
        
        int[] result = new int[ret.size()];
        
        for(int i = 0; i < ret.size(); i++){
        	result[i] = ret.get(i);
        }
        
        return result;
    }
}