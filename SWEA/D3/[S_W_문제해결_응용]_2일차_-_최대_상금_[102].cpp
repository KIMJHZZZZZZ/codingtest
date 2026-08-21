#include<iostream>
#include<algorithm>
#include<string>
#include<cstring>
using namespace std;
int t, num, ret, visited[11][1000004];
string str;

void go(int check) {
	if (check > num) {
		ret = max(ret, stoi(str));
		return;
	}

	for (int i = 0; i < str.length(); i++) {
		for (int j = i + 1; j < str.length(); j++) {
			swap(str[i], str[j]);
			int changeStr = stoi(str);
			if (!visited[check][changeStr]) {
				visited[check][changeStr] = 1;
				go(check + 1);
			}
			swap(str[i], str[j]);
		}
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		memset(visited, 0, sizeof(visited));
		ret = 0;
		cin >> str >> num;
		go(1);
		cout << "#" << tc << " " << ret << "\n";
	}
	return 0;
}