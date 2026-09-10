import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[24];
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ret = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 최대 n = 20, i의 범위는 1050000, j의 범위는 20 => 최대 약 2천만으로 모든 경우의 수 탐색 가능
			// n = 5 라면, 00000, 00001, 00010, 00011, 00100, 00101, 00110, 000111, ... 01111 = (0,1,2,3,4,5,6,7,... ,31)
			// 1 = 선택된 직원, 0 = 선택되지 않은 직원
			for(int i = 0; i < (1 << n); i++){
				int sum = 0;
				for(int j = 0; j < n; j++){
					// j 가 만약 5 라면 00001, 00010, 00100, 01000, 10000 -> i의 각 자리가 켜져있는지 확인
					if((i & (1 << j)) != 0){
						sum += arr[j];
					}
				}
				if(sum >= b){
					ret = Math.min(ret, sum);
				}
			}
			System.out.println("#" + tc + " " + (ret - b));
		}
	}
}