#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    for(int i = 1; i < triangle.size(); i++){
        for(int j = 0; j < triangle[i].size(); j++){
            if(j < 1) {triangle[i][j] += triangle[i - 1][j];}
            else if(j == triangle[i].size() - 1) triangle[i][j] += triangle[i - 1][j - 1];
            else{
               int selectNum = max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                triangle[i][j] += selectNum;
            }
        }
    }
    int size = triangle[triangle.size() - 1].size();
    for(int i = 0; i < size; i++){
        answer = max(answer, triangle[size - 1][i]);
    }
    return answer;
}