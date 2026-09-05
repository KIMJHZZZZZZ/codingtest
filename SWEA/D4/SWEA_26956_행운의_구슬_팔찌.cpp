#include<iostream>
#include<vector>
using namespace std;
int t, n, m, k, num;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		vector<int> v;
		int idx = 0;
		cin >> n >> m >> k;
		
		for(int i = 0; i < n; i++){
			cin >> num;
			v.push_back(num);
		}
		for(int i = 0; i < k; i++){
			idx += m;
			if(idx >= v.size()){
				idx %= v.size();
			}
			
			if(idx == 0){
				v.push_back(v[0] + v[v.size() - 1]);
				idx = v.size() - 1;
			}
			else{
				v.insert(v.begin() + idx, v[idx - 1] + v[idx]);
			}
		}
		int cnt = 0;
		cout << "#" << tc;
		for(int i = v.size() - 1; i >= 0; i--){
			if(cnt >= 10) break;
			cout << " " << v[i];
			cnt++;
		}
		cout << '\n';
	}
	return 0;
}