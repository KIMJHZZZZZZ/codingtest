#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;
set<int> s[10];

int solution(int N, int number) {
    for(int i = 1; i <= 8; i++){
        int repeat = 0;
        for(int k = 0; k < i; k++) repeat = repeat * 10 + N;
        s[i].insert(repeat);
        
        for(int j = 1; j < i; j++){
            for(int a : s[j]){
                for(int b : s[i - j]){
                    s[i].insert(a + b);
                    s[i].insert(a - b);
                    s[i].insert(a * b);
                    if(b != 0) s[i].insert(a / b); 
                }
            }
        }
        
        if(s[i].count(number)) return i;
    }
    return -1;
}