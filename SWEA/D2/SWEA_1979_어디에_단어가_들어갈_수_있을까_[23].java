import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= 10; tc++) {
			int[][] arr = new int[20][20];
			int ret = 0;
			int n = sc.nextInt();
			int k = sc.nextInt();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] == 1) {
						int cnt = 1;
						while(j < n) {
							j++;
							if(arr[i][j] == 0) break;
							cnt++;
						}
						if(cnt == k) ret++;
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[j][i] == 1) {
						int cnt =1;
						while(j < n) {
							j++;
							if(arr[j][i] == 0) break;
							cnt++;
						}
						if(cnt == k) ret++;
					}
				}
			}
			System.out.println("#" + tc + " " + ret);
		}
	}
}
