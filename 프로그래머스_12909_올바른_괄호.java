import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Deque<Character> dq = new ArrayDeque<>();
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				dq.offer('(');
			}
			else{
				if(!dq.isEmpty() && dq.peekLast() == '(') {
					dq.pollLast();
				}
				else{
					answer = false;
					break;
				}				
			}
		}
		if(!dq.isEmpty()) answer = false;
        return answer;
    }
}