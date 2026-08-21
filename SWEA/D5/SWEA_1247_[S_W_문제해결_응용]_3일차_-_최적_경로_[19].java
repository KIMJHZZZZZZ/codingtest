import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int c_x, c_y, h_x, h_y, min_ret = 123456789;

	static void go(int depth, Pair[] list, int[] check, boolean[] visited, int n) {
		if (depth == n) {
			int tmp_ret = 0;
			int t_hx = h_x;
			int t_hy = h_y;
			for(int i = 0; i < n ; i++) {
				tmp_ret += (Math.abs(t_hx - list[check[i]].getLeft()) + Math.abs(t_hy - list[check[i]].getRight()));
				t_hx = list[check[i]].getLeft();
				t_hy = list[check[i]].getRight();
			}
			tmp_ret += (Math.abs(t_hx - c_x) + Math.abs(t_hy - c_y));
			min_ret = Math.min(min_ret, tmp_ret);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			check[depth] = i;
			go(depth + 1, list, check, visited, n);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			c_x = sc.nextInt();
			c_y = sc.nextInt();
			h_x = sc.nextInt();
			h_y = sc.nextInt();
			Pair[] list = new Pair[14];
			int[] check = new int[14];
			boolean[] visited = new boolean[14];
			min_ret = 123456789;
			for (int i = 0; i < n; i++) {
				int left = sc.nextInt();
				int right = sc.nextInt();
				// System.out.println(left + " " + right);
				// list.add(new Pair(left, right));
				list[i] = new Pair(left, right);
			}
			go(0, list, check, visited, n);
			
			System.out.println("#" + tc + " " + min_ret);
		}
	}
}

class Pair {
	int left;
	int right;

	public Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}
}
