import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int n, L, ret;
	
	static void go(int start, int sum, int size, boolean[] visited, List<Pair> v) {
		if(size > L) {
			return;
		}
		ret = Math.max(ret, sum);
		for(int i = start; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			go(i + 1, sum + (int)v.get(i).getLeft(), size + (int)v.get(i).getRight(), visited, v);
			visited[i] = false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int t = 0;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			boolean[] visited = new boolean[24];
			List<Pair> v =new ArrayList<>();
			n = sc.nextInt();
			L = sc.nextInt();
			ret = 0;
			int point = 0, cal = 0;
			for (int i = 0; i < n; i++) {
				point = sc.nextInt();
				cal = sc.nextInt();
				v.add(new Pair<>(point, cal));
			}
			
			
			Collections.sort(v, new Comparator() {

				@Override
				public int compare(Object o1, Object o2) {
					if(o1 instanceof Pair && o2 instanceof Pair) {
						Pair<Integer, Integer> p1 = (Pair<Integer, Integer>) o1;
					    Pair<Integer, Integer> p2 = (Pair<Integer, Integer>) o2;
					    return Integer.compare(p1.getRight(), p2.getRight());
					}
					return 1;
				}
				
			});
			
			
//			for (int i = 0; i < n; i++) {
//				System.out.println(v.get(i).getLeft() + " " + v.get(i).getRight());
//			}
//			
			go(0, 0, 0, visited, v);
			
			System.out.println("#" + tc + " " + ret);
		}
	}
}

class Pair<L, R> {
    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }
    
    public void setLeft(L left) { this.left = left; }
    public void setRight(R right) { this.right = right; }
}