import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int[] dp = new int[10004];
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Pair> list = new ArrayList<>();
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			for(int i = 0; i < n; i++){
				st = new StringTokenizer(br.readLine());
				int point = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				list.add(new Pair(point, k));
			}
			for(int i = 0; i < n; i++){
				int point = list.get(i).getLeft();
				int k = list.get(i).getRight();
				for(int j = l; j >= k; j--){
					dp[j] = Math.max(dp[j], dp[j - k] + point);
				}
			}
			System.out.println("#" + tc + " " + dp[l]);
		}
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
}