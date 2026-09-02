#include<iostream>
using namespace std;
int t, n, arr[1004], i;

void go(int index){
	if(index > n) return;
	
	go(index * 2);
	arr[index] = ++i;
	go(index * 2 + 1);
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		cin >> n;
		i = 0;
		go(1);
		cout << "#" << tc << " " << arr[1] << " " << arr[n / 2] << '\n';
	}
	return 0;
}