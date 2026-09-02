#include<iostream>
#include<cstring>
using namespace std;
int t, n, num, idx, arr[504];

void go(int number){
	
	int index = ++idx;
	arr[index] = number;
	while(index > 1 && arr[index / 2] > number){
		int tmp = arr[index / 2];
		arr[index / 2] = number;
		arr[index] = tmp;
		index /= 2; 
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		memset(arr, 0, sizeof(arr));
		idx = 0;
		cin >> n;
		for(int i = 0; i < n; i++){
			cin >> num;
			go(num);
		}
		int sum = 0;
		while(n >= 1){
			n /= 2;
			sum += arr[n];
		}
		cout << "#" << tc << " " << sum << '\n'; 
	}
	return 0;
}