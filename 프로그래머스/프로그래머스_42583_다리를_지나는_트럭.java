import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0, cnt = 0, canWeight = weight, flag = 0;
        
        Deque<Pair> dq = new ArrayDeque<>();
		
        while(true){
        	if(flag >= truck_weights.length) break;
        	if (idx < truck_weights.length
                && canWeight >= truck_weights[idx]) {
                canWeight -= truck_weights[idx];
                dq.offer(new Pair(truck_weights[idx], cnt));
                idx++;
            }
        	cnt++;
        	while (!dq.isEmpty()
                    && cnt - dq.peekFirst().getRight() >= bridge_length) {
                canWeight += dq.pollFirst().getLeft();
                flag++;
            }
        }
        return cnt + 1;
    }
}

class Pair{
	int left;
	int right;
	
	public Pair(int left, int right){
		this.left = left;
		this.right = right;
	}
	
	public int getLeft(){
		return this.left;
	}
	
	public int getRight(){
		return this.right;
	}
	
	public void setLeft(int left){
		this.left = left;
	}
	
	public void setRight(int right){
		this.right = right;
	}
}