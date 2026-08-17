import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int ret1, ret2;
	static int[] point = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

	static void check_point(List<Integer> in, int[] gyu) {
		int w1 = 0, w2 = 0;
		for (int i = 0; i < 9; i++) {
			if (in.get(i) > gyu[i])
				w1 += in.get(i) + gyu[i];
			else
				w2 += in.get(i) + gyu[i];
		}
		if(w1 > w2) ret1++;
		if(w1 < w2) ret2++;

	}

	static void go(int[] arr, List<Integer> in, int[] gyu, int depth, int size) {
		if (depth == size) {
			check_point(in, gyu);
			return;
		}

		for (int i = 1; i <= 18; i++) {
			if (arr[i] == 0) {
				arr[i] = 1;
				gyu[depth] = i;
				go(arr, in, gyu, depth + 1, size);
				arr[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			ret1 = 0;
			ret2 = 0;
			int[] arr = new int[20];
			List<Integer> in = new ArrayList<Integer>();
			for (int i = 0; i < 9; i++) {
				int num = sc.nextInt();
				arr[num] = 1;
				in.add(num);
			}
			int[] gyu = new int[10];
			go(arr, in, gyu, 0, 9);

			System.out.println("#" + tc + " " + ret1 + " " + ret2);
		}
	}
}
