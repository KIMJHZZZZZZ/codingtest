import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int ret = 0;
			int[] weightVisited = new int[104];
			int[] peopleVisited = new int[104];
			int n = sc.nextInt();
			int m = sc.nextInt();
			List<Integer> weightList = new ArrayList<>();
			List<Integer> peopleList = new ArrayList<>();
			for(int i = 0; i < n; i++){
				int num = sc.nextInt();
				weightList.add(num);
			}
			for(int i = 0; i < m; i++){
				int num = sc.nextInt();
				peopleList.add(num);
			}
			weightList.sort(Collections.reverseOrder());
			peopleList.sort(Collections.reverseOrder());
			int idx = 0;
			for(int i = 0; i < n; i++){
				if(weightVisited[i] == 1) continue;
				for(int j = 0; j < m; j++){
					if(peopleVisited[j] == 1) continue;
					int w = weightList.get(i);
					int p = peopleList.get(j);
					//System.out.println("w: " + w + ", p:" + p);
					if(p >= w){
						ret += w;
						weightVisited[i] = 1;
						peopleVisited[j] = 1;
						break;
					}
				}
			}	
			System.out.println("#" + tc + " " + ret);		
		}
	}
}