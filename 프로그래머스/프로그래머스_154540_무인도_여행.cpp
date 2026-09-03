#include <string>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
int visited[104][104];
int n, m;
int sum  = 0; 

void go(int x, int y, vector<string>& maps){
	for(int i = 0; i < 4; i++){
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 'X') continue;
		if(visited[nx][ny]) continue;
		visited[nx][ny] = 1;
		sum += (maps[nx][ny] - '0');
		go(nx, ny, maps);
	}
}


vector<int> solution(vector<string> maps) {
    vector<int> answer;
    
    n = maps.size();
    m = maps[0].size();
    memset(visited, 0, sizeof(visited));
    
    for(int i = 0; i < maps.size(); i++){
    	for(int j = 0; j < maps[i].size(); j++){
    		char c = maps[i][j];
    		if(!visited[i][j] && (c != 'X')){
    			sum = (c - '0');
    			visited[i][j] = 1;
    			go(i, j, maps);
    			answer.push_back(sum);
    		}
    	}
    }
    sort(answer.begin(), answer.end());
    if(answer.size() == 0) answer.push_back(-1);
    return answer;
}