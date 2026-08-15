import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			String ret = "";
			int check = sc.nextInt();
			int num = sc.nextInt();
			int cnt = 0;
			while(num > 0) {
				if(num % 2 == 1) {
					cnt++;
					if(cnt == check) break;
				}
				else {
					break;
				}
				num /= 2;
			}
			if(cnt == check) ret = "ON";
			else ret = "OFF";
			
			System.out.println("#" + tc + " " + ret);
		}
	}
}
