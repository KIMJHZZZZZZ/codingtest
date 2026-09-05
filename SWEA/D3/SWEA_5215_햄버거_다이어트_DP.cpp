#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
int t, n, maxK, p, k, ret[10004];
vector<pair<int,int> > vp;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		memset(ret, 0, sizeof(ret));
		vp.clear();
		cin >> n >> maxK;
		for(int i = 0; i < n; i++){
			cin >> p >> k;
			vp.push_back({k , p});
		}
		for(int i = 0; i < n; i++){
			int curK = vp[i].first;
			int curP = vp[i].second;
			for(int j = maxK; j >= curK; j--){
				ret[j] = max(ret[j], ret[j - curK] + curP);
			}
		}
		cout << "#" << tc << " " << ret[maxK] << '\n';
	}
	return 0;
}