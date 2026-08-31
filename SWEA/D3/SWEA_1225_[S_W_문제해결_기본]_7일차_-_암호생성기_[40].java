import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			Deque<Integer> arr = new ArrayDeque<>();
			int t = sc.nextInt();
			for(int i = 0; i < 8; i++) {
				int num = sc.nextInt();
				arr.offerLast(num);
			}
			int i = 1;
			while(true) {
				int first = arr.pollFirst();
				if((first - i) <= 0) {
					arr.offerLast(0);
					break;
				}
				arr.offerLast(first - i);
				i++;
				if(i > 5) i = 1;
			} 
			System.out.print("#" + t);
			while(!arr.isEmpty()) {
				System.out.print(" " + arr.pollFirst());
			}
			System.out.println();
		}
	}
}
