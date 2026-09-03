#include<vector>
#include<queue>
#include<cstring>
using namespace std;
int dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1};

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    int visited[104][104];
    int n = maps.size(), m = maps[0].size();
	memset(visited, 0, sizeof(visited));
    queue<pair<int,int>> q;
    q.push({0,0});
    visited[0][0] = 1;
    while(q.size()){
    	int x = q.front().first;
    	int y = q.front().second;
    	q.pop();
    	for(int i = 0; i < 4; i++){
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(nx < 0 || ny < 0 || nx >= n  || ny >= m || maps[nx][ny] == 0)continue;
    		if(visited[nx][ny])continue;
    		visited[nx][ny] = visited[x][y] + 1;
    		q.push({nx,ny});
    	}
    }
    if(visited[n - 1][m - 1] == 0) answer = -1;
    else answer = visited[n - 1][m - 1];
    return answer;
}