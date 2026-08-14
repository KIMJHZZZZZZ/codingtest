import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int ret = 123456789;
	static int cnt = 0;
	
	static void min_ret(boolean[] visited, int num, int[][] arr) {
		int ret1 = 0, ret2 = 0;
		for(int i = 0 ; i < num; i++) {
			for(int j = 0 ; j < num; j++) {
				if(visited[i] && visited[j]) {
					ret1 += arr[i][j];
				}
			}
		}
		
		for(int i = 0 ; i < num; i++) {
			for(int j = 0 ; j < num; j++) {
				if(!visited[i] && !visited[j]) {
					ret2 += arr[i][j];
				}
			}
		}
		
		ret = Math.min(ret, Math.abs(ret1 - ret2));
	}
	

	static void go(int start, int size, List<Integer> check, int[][] arr) {
		if (check.size() >= size / 2) {
			//cnt++;
			boolean[] visited = new boolean[20];
			//System.out.println("cnt : " + cnt + " ");
			for(int i = 0; i < check.size(); i++) {
				//System.out.print(check.get(i) + " ");
				visited[check.get(i)] = true;
			}
			//System.out.println();
			min_ret(visited, size, arr);
			return;
		}

		for (int i = start; i < size; i++) {
			check.add(i);
			go(i + 1, size, check, arr);
			check.remove(check.size() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			ret = 123456789;
			int[][] arr = new int[20][20];
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			List<Integer> check = new ArrayList<>();
			go(0, n, check, arr);
			
			System.out.println("#" + tc + " " + ret);
		}
	}
}
