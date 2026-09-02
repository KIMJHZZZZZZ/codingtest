import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int v_num = sc.nextInt();
			int e_num = sc.nextInt();
			List<Integer>[] list = new ArrayList[v_num + 1];
			for (int i = 1; i <= v_num; i++) {
                list[i] = new ArrayList<>();
            }
			int[] indegree = new int[v_num + 1];
			for(int i = 0; i < e_num; i++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				list[start].add(end);
				indegree[end]++;
			}	
			Deque<Integer> dq = new ArrayDeque<>();
			for(int i = 1; i <= v_num; i++){
				if(indegree[i] == 0) dq.offer(i);
			}
			System.out.print("#" + tc); 
			while(!dq.isEmpty()){
				int x = dq.pollFirst();
				System.out.print(" " + x);
				for(int there:list[x]){
					indegree[there]--;
					if(indegree[there] == 0){
						dq.offer(there);
					}
				}
			}
			System.out.println();
		}
	}
}