#include<iostream>
#include<map>
#include<string>
using namespace std;
int t, dx[] = { -1,0,1,0 }, dy[] = { 0,1,0,-1 };
map<string, int> m;
string arr[10][10];

void go(int x, int y, string s) {
	if (s.length() >= 7) {
		//cout << "S : " << s << "\n";
		m[s] = 1;
		return;
	}

	for (int i = 0; i < 4; i++) {
		int nx = dx[i] + x;
		int ny = dy[i] + y;
		if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)continue;
		go(nx, ny, s + arr[nx][ny]);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		m.clear();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cin >> arr[i][j];
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				go(i, j, "");
			}
		}
		cout << "#" << tc << " " << m.size() << "\n";
	}
	return 0;
}