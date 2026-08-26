#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
int t, n, x, y, minV;
int cx, cy, hx, hy;
int visited[14];
vector<pair<int, int>> vp;

int getDistance(int a, int b) {
	return abs(vp[a].first - vp[b].first) + abs(vp[a].second - vp[b].second);
}

void go(int depth, int val, int s_idx) {
	if (val >= minV) return;
	if (depth == n) {
		val += abs(vp[s_idx].first - hx)
			+ abs(vp[s_idx].second - hy);
		minV = min(minV, val);
		return;
	}

	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			visited[i] = 1;
			go(depth + 1, val + getDistance(s_idx, i), i);
			visited[i] = 0;
		}
	}
	return;
}

int main() {
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		minV = 1e9;
		memset(visited, 0, sizeof(visited));
		vp.clear();
		cin >> n;
		cin >> cx >> cy >> hx >> hy;
		vp.push_back({ cx, cy });
		for (int i = 0; i < n; i++) {
			cin >> x >> y;
			vp.push_back({ x, y });
		}
		vp.push_back({ hx, hy });
		go(0, 0, 0);
		cout << "#" << tc << " " << minV << "\n";
	}
	return 0;
}