#include <string>
#include <vector>

using namespace std;
// int ret = 0;
// void go(int start, int sum, vector<int>& numbers, int target){
	// if(start > numbers.size() - 1){
		// if(sum == target) ret++;
		// return;
	// }
	// for(int i = 0; i < 2; i++){
		// if(i == 0) go(start + 1, sum + numbers[start], numbers, target);
		// if(i == 1) go(start + 1, sum - numbers[start], numbers, target);
	// }
// }

int go(int start, int sum, vector<int>& numbers, int target){
	if(start > numbers.size() - 1){
		return (sum == target) ? 1 : 0;
	}
	
	return go(start + 1, sum + numbers[start], numbers, target) 
	+ go(start + 1, sum - numbers[start], numbers, target); 
}

int solution(vector<int> numbers, int target) {
    return go(0, 0, numbers, target);
}