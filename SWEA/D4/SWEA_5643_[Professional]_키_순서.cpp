#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
int t, n, m, a, b, cnt;
vector<int> v[504];
int push[504], pull[504], visited[504];

void DFS(int here){
	
	for(int there:v[here]){
		if(visited[there]) continue;
		pull[there] += 1;
		cnt++;
		visited[there] = 1;
		DFS(there);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		for(int i = 0; i < 504; i++){
			v[i].clear();
		}
		memset(push, 0, sizeof(push));
		memset(pull, 0, sizeof(pull));
		cin >> n >> m;
		for(int i = 0; i < m; i++){
			cin >> a >> b;
			v[a].push_back(b);
		}
		for(int i = 1; i <= n; i++){
			memset(visited, 0, sizeof(visited));
			cnt = 0;
			visited[i] = 1;
			DFS(i);
			push[i] += cnt;
		}
		cnt = 0;
		for(int i = 1; i <= n; i++){
			if(push[i] + pull[i] == n - 1) cnt++;			
		}
		cout << "#" << tc << " " << cnt << '\n';
	}
	return 0;
}