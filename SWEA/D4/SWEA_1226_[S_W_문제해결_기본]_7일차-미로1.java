import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution{
	static int sx, sy, ex, ey;
	static int dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			int[][] arr = new int[20][20];
			boolean[][] visited = new boolean[20][20];
			for(int i = 0; i < 16; i++){
				String str = sc.next();
				for(int j = 0; j < 16; j++){
					 arr[i][j] = str.charAt(j) - '0';
					 if(arr[i][j] == 2){
					 	sx = i;
					 	sy = j;
					 }
					 if(arr[i][j] == 3){
					 	ex = i;
					 	ey = j;
					 }
				}
			}
			Deque<Pair> dq = new ArrayDeque<>();
			dq.offer(new Pair(sx, sy));
			visited[sx][sy] = true;
			while(!dq.isEmpty()){
				int x = dq.peekFirst().getX();
				int y = dq.peekFirst().getY();
				dq.pollFirst();
				
				if(visited[ex][ey]){
					break;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16)continue;
					if(arr[nx][ny] == 1) continue;
					if(visited[nx][ny]) continue;
					visited[nx][ny] = true;
					dq.offer(new Pair(nx, ny));
				}
			}
			int ret = 0;
			if(visited[ex][ey]) ret = 1;
			System.out.println("#" + t + " " + ret);
		}
	}
}

class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}



