import java.io.*;
import java.util.*;

public class Solution {

	static int h, w, x, y, dir;

	// 북 동 남 서
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int changeDir(char c){
		if(c == '^') return 0;
		if(c == '>') return 1;
		if(c == 'v') return 2;
		return 3;
	}
	
	static void move(int dir, char[][] crr){
		int nx = x + dx[dir];
	    int	ny = y + dy[dir];
		if(nx < 0 || ny < 0 || nx >= h || ny >= w) return;
		if(crr[nx][ny] != '.') return;
		char tmp = crr[x][y];
		crr[x][y] = crr[nx][ny];
		crr[nx][ny] = tmp;
		x = nx;
		y = ny;
	}
	
	static void go(char[][] crr, char c){
		if(c == 'U'){
			dir = 0;
			crr[x][y] = '^';
			move(dir, crr);
		}
		else if(c == 'D'){
			dir = 2;
			crr[x][y] = 'v';
			move(dir, crr);
		}
		else if(c == 'L'){
			dir = 3;
			crr[x][y] = '<';
			move(dir, crr);
		}
		else if(c == 'R'){
			dir = 1;
			crr[x][y] = '>';
			move(dir, crr);
		}
		else if(c == 'S'){
			int tx = x, ty = y;
			while(true){
				x += dx[dir];
				y += dy[dir];
				if(x < 0 || y < 0 || x >= h || y >= w) break;
				if(crr[x][y] == '#') break;
				if(crr[x][y] == '*'){
					crr[x][y] = '.';
					break;
				}
			}
			x = tx;
			y = ty;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char[][] crr = new char[24][24];
			
    		h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			char curPos = '>';
			x = 0;
			y = 0;
			
			for(int i = 0; i < h; i++){
				String str = br.readLine();
				for(int j = 0; j < w; j++){
					crr[i][j] = str.charAt(j);
					if(crr[i][j] == '^' || crr[i][j] == '>' || crr[i][j] == '<' || crr[i][j] == 'v'){
						curPos = crr[i][j];
						x = i;
						y = j;
					} 
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			dir = changeDir(curPos);
			
			for(int i = 0; i < str.length(); i++){
				char c = str.charAt(i);
				go(crr, c);
			}
			
			System.out.print("#" + tc + " "); 
			for(int i = 0; i < h; i++){
				for(int j = 0; j < w; j++){
					System.out.print(crr[i][j]);
				}
				System.out.println();
			}
		}
	}
}