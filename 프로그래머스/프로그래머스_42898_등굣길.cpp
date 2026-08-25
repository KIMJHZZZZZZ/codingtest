#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#define E 1000000007
using namespace std;
long long dp[104][104];

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    memset(dp,0,sizeof(dp));
    for(int i = 0; i < puddles.size(); i++){
        dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
    }
    for(int i = 0 ; i < m; i++){
        if(dp[0][i] == -1) break;
        dp[0][i] = 1;
    }
    for(int i = 0 ; i < n; i++){
        if(dp[i][0] == -1) break;
        dp[i][0] = 1;
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(i == 0 && j == 0) continue;
             
            if(dp[i][j] == -1) {
                dp[i][j] = 0;
                continue;
            }
            
            long long up = (i > 0) ? dp[i - 1][j] : 0;
            long long left = (j > 0) ? dp[i][j - 1] : 0;
            
            dp[i][j] = (up + left) % E; 
        }
    }
    
    // for(int i = 0; i < n; i++){
    //     for(int j = 0; j < m; j++){
    //         cout << dp[i][j] << " ";
    //     }
    //     cout << '\n';
    // }
    answer = dp[n - 1][m - 1];
    return answer;
}