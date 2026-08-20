// 풀이 1

#include<iostream>
#include<string>
using namespace std;
int t, cnt;
string check, str;
bool checkStr(int idx) {
	for (int i = 0; i < check.length(); i++) {
		if (str[idx + i] != check[i]) {
			return false;
		}
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (int tc = 1; tc <= 10; tc++) {
		cnt = 0;
		cin >> t >> check >> str;
		for (int i = 0; i < str.length(); i++) {
			if (str[i] == check[0]) {
				if (checkStr(i)) {
					cnt++;
					i += check.length();
				}
			}
		}
		cout << "#" << tc << " " << cnt << '\n';
	} 
	return 0;
}

// 풀이 2

#include<iostream>
#include<string>
using namespace std;
int t, cnt;
string check, str;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (int tc = 1; tc <= 10; tc++) {
		cnt = 0;
		cin >> t >> check >> str;
		size_t pos = 0;
		while ((pos = str.find(check, pos)) != string::npos) {
			pos += check.length();
			cnt++;
		}
		cout << "#" << tc << " " << cnt << '\n';
	} 
	return 0;
}
