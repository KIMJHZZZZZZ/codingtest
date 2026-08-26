#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int t, n, num, max_h = -1, one, two, ret;
vector<int> v;
int main() {
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		v.clear();
		ret = 0; one = 0; two = 0;
		max_h = -1;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> num;
			v.push_back(num);
			max_h = max(max_h, num);
		}
		for (int i = 0; i < n; i++) {
			int diff = max_h - v[i];
			one += (diff % 2);
			two += (diff / 2);
		}
		while (two > one + 1) {
			two--;
			one += 2;
		}

		if (two >= one) {
			ret = two * 2;
		}
		else {
			ret = one * 2 - 1;
		}

		cout << "#" << tc << " " << ret << '\n';
	}
}