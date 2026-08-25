#include<iostream>
#include<string>
#include<algorithm>
#include<cstring>
#include<vector>
using namespace std;
int t, v_num, e_num, x, y, indegree[1004], done[1004];
vector<int> v[1004];

void go(int here) {
	if (done[here]) return;
	done[here] = 1;
	for (int there : v[here]) {
		if(indegree[there])
			indegree[there] -= 1;
	}
	for (int there : v[here]) {
		if (done[there]) continue;
		if (!indegree[there]) {
			cout << there << " ";
			go(there);
		}
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (int tc = 1; tc <= 10; tc++) {
		cin >> v_num >> e_num;
		for (int i = 1; i <= v_num; i++) {
			v[i].clear();
		}
		memset(indegree, 0, sizeof(indegree));
		memset(done, 0, sizeof(done));
		for (int i = 0; i < e_num; i++) {
			cin >> x >> y;
			indegree[y]++;
			v[x].push_back(y);
		}
		cout << "#" << tc << " ";
		for (int i = 1; i <= v_num; i++) {
			if (indegree[i] || done[i]) continue;
			cout << i << " ";
			go(i);
		}
		cout << "\n";
	}
	return 0;
}