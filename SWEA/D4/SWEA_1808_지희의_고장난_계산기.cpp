#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
const int INF = 1e9;
int t, cnt, arr[14], num, target, min_ret = INF;
vector<vector<int>> vv;
vector<vector<string>> sv;
vector<int> tmp;
void go(int x, int num) {
	tmp.push_back(x);
	vv.push_back(tmp);
	tmp.pop_back();
	for (int i = num; i * i <= x; i++) {
		if (x % i == 0) {
			tmp.push_back(i);
			go(x / i, i);
			tmp.pop_back();
		}
	}
	return;
}

void check(vector<string>& t_s_v) {
	int ret = 0;
	for (int i = 0; i < t_s_v.size(); i++) {
		for (int j = 0; j < t_s_v[i].length(); j++) {
			if (!arr[t_s_v[i][j] - '0']) return;
		}
		ret += t_s_v[i].length();
	}
	ret += (t_s_v.size() - 1);
	min_ret = min(min_ret, ret);
	return;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		vv.clear();
		sv.clear();
		tmp.clear();
		min_ret = INF;
		for (int i = 0; i < 10; i++) {
			cin >> num;
			arr[i] = num;
		}
		cin >> target;
		go(target, 2);
		for (int i = 0; i < vv.size(); i++) {
			vector<string> s_tmp;
			for (int j = 0; j < vv[i].size(); j++) {
				s_tmp.push_back(to_string(vv[i][j]));
			}
			sv.push_back(s_tmp);
		}

		for (int i = 0; i < sv.size(); i++) {
			check(sv[i]);
		}

		if (min_ret == INF) cout << "#" << tc << " " << -1 << "\n";
		else cout << "#" << tc  << " " << min_ret + 1 << "\n";
	}
	return 0;
}