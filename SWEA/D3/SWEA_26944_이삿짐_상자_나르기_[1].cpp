#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
int t, n, m, num, visited1[104], visited2[104];
vector<int> v1, v2;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		int ret = 0;
		memset(visited1, 0, sizeof(visited1));
		memset(visited2, 0, sizeof(visited2));
		v1.clear();
		v2.clear();
		cin >> n >> m;
		for (int i = 0; i < n; i++) {
			cin >> num;
			v1.push_back(num);
		}
		for (int i = 0; i < m; i++) {
			cin >> num;
			v2.push_back(num);
		}
		sort(v1.rbegin(), v1.rend());
		sort(v2.rbegin(), v2.rend());

		for (int i = 0; i < m; i++) {
			if (visited2[i]) continue;
			for (int j = 0; j < n; j++) {
				if (visited1[j]) continue;
				if (v2[i] >= v1[j]) {
					visited2[i] = 1;
					visited1[j] = 1;
					ret += v1[j];
					break;
				}
			}
		}
		cout << "#" << tc << " " << ret << "\n";
	}
	return 0;
}