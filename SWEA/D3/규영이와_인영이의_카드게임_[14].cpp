#include<iostream>
#include<cstring>
#include<vector>
using namespace std;
int  t, arr[20], num, cnt, visited[20], output[20], ret1, ret2;
int fac[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
vector<int> in;

void go(int depth, int w1, int w2, int output[20], int visited[20]) {

	if (w1 > 85) {
		ret1 += fac[9 - depth];
		return;
	}

	if (w2 > 85) {
		ret2 += fac[9 - depth];
		return;
	}

	if (depth == 9) {
		if (w1 > w2) ret1++;
		if (w1 < w2) ret2++;
		return;
	}

	for (int i = 1; i <= 18; i++) {
		if (!arr[i] && !visited[i]) {
			visited[i] = 1;
			output[depth] = i;
			if (in[depth] > output[depth]) {
				go(depth + 1, w1 + i +in[depth], w2, output, visited);
			}
			if (in[depth] < output[depth]) {
				go(depth + 1, w1, w2 + i + in[depth], output, visited);
			}
			visited[i] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		cnt = 0; ret1 = 0; ret2 = 0;
		memset(arr, 0, sizeof(arr));
		memset(visited, 0, sizeof(visited));
		memset(output, 0, sizeof(output));
		in.clear();
		for (int i = 0; i < 9; i++) {
			cin >> num;
			in.push_back(num);
			arr[num] = 1;
		}
		go(0, 0, 0, output, visited);
		cout << "#" << tc << " "  << ret1 << " " << ret2 << '\n';
	}


	return 0;
}