import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int max_ret = 0;

	static void go(int size, String str, boolean[][] visited, int t_num) {
		if (size == t_num) {
			max_ret = Math.max(max_ret, Integer.parseInt(str));
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				str = swapChars(str, i, j);
				
				if(!visited[size][Integer.parseInt(str)]) {
					visited[size][Integer.parseInt(str)] = true;
					go(size + 1, str, visited, t_num);
				}
				
				str = swapChars(str, i, j);
			}
		}
	}
	
	static String swapChars(String str, int i, int j){
	    char[] c_arr = str.toCharArray();

	    char temp = str.charAt(i);
	    c_arr[i] = str.charAt(j);
	    c_arr[j] = temp;

	    return new String(c_arr);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			max_ret = 0;
			String str = sc.next();
			int t_num = sc.nextInt();
			boolean[][] visited = new boolean[10][1000004];
			go(0, str, visited, t_num);
			System.out.println("#" + tc + " " + max_ret);
		}
	}
}
