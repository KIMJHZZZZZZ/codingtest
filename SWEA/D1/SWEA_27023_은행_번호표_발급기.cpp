#include <iostream>
#include <queue>
using namespace std;

int main(){
    int t = 0, n = 0;
    cin >> t;
    for(int tc = 1; tc<=t; tc++){
        queue<int> q, ret;
        cin >> n;
        int num = 1, call = 0;
        for(int i = 0; i < n; i++){
            cin >> call;
            if(call == 1){
                q.push(num++);
            }
            if(call == 2){
                ret.push(q.front());
                q.pop();
            }
        }
        
        cout << "#"  << tc << " ";
        while(ret.size()){
            cout << ret.front() << " ";
            ret.pop();
        }
        cout << '\n';
    }
    return 0;
}