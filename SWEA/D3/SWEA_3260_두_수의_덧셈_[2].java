import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static void go(String long_str, String short_str, Stack<Integer> stk) {
		int i = 1, carry = 0;
		int long_str_len = long_str.length();
		int short_str_len = short_str.length();
		while(i <= short_str_len) {
			stk.push(short_str.charAt(short_str_len - i) - '0');
			int next = (long_str.charAt(long_str_len - i) -'0') + stk.pop() + carry;
			carry = next / 10;
			stk.push(next % 10);
			i++;
		}
		for(int j = long_str_len - i; j >= 0; j--) {
			int next = (long_str.charAt(j) - '0') + carry;
			carry = next / 10;
			stk.push(next % 10);
		}
		if(carry == 1) stk.push(carry);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			String a = sc.next();
			String b = sc.next();
			Stack<Integer> stk = new Stack<>();
			int i = 1, carry = 0;
			int a_len = a.length();
			int b_len = b.length();
			if(a_len > b_len) {
				go(a, b, stk);
			}
			else {
				go(b, a, stk);
			}
			
			System.out.print("#" + tc + " ");
			while(!stk.isEmpty()) {
				System.out.print(stk.pop());
			}
			System.out.println();
		}
	}
}
