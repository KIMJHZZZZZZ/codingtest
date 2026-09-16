import java.util.*;
import java.io.*;

public class Solution {

	// dx, dy 8방향 구현
	static int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	// dfs(int x, int y, )
	// 방향 탐색 시 8 방향이 모두 지뢰가 아니라면 그곳을 재귀 호출
	static void dfs(int x, int y, int n, char[][] arr, boolean[][] visited) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if(visited[nx][ny]) continue;
			visited[nx][ny] = true;
			if(arr[nx][ny] == '.' && check(nx, ny, n, arr)) {
				dfs(nx, ny, n, arr, visited);
			}
		}
	}
	
	static boolean check(int x, int y, int n, char[][] arr) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if(arr[nx][ny] == '*') {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// n 입력 받기
			int n = Integer.parseInt(st.nextToken());
			// char[][] 배열 생성
			char[][] arr = new char[n + 4][n + 4];
			boolean[][] visited = new boolean[n + 4][n + 4];
			
			// 입력 받기
			for(int i = 0; i < n; i++){
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int j = 0; j < n; j++){
					arr[i][j] = str.charAt(j);
				}
			}
			
			//  dfs로 '.' 인 부분을 누르기
			// 누르는 부분을 visited 체크
			// n * n 크기만큼 '.' 이면 visited 체크 후 dfs 돌리기
			// 이 횟수 만큼 cnt++ 
			
			int cnt = 0;
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(visited[i][j]) continue;
					if(arr[i][j] == '.' && check(i, j, n, arr)) {
						visited[i][j] = true;
						dfs(i, j, n, arr, visited);
						cnt++;
					}
				}
			}
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(!visited[i][j] && arr[i][j] == '.') {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}