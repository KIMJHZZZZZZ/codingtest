import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			Map<Integer, Integer> ret_map = new HashMap<>();
			int max = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					int num = i + j;
					ret_map.put(num, ret_map.getOrDefault(num, 0) + 1);
					max = Math.max(max, ret_map.getOrDefault(num, 0));
				}
			}
			System.out.print("#" + tc);
			for(Map.Entry<Integer, Integer> tmp : ret_map.entrySet()) {
				if(tmp.getValue() == max) System.out.print(" " + tmp.getKey());
			}
			System.out.println();
		}
	}
}
