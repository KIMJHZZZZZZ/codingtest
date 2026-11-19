class Solution {
    
    static int cnt;
    
    static void go(int depth, int sum, int n, int[] numbers, int target){
        if(depth == n){
            if(target == sum) cnt++;
            return;
        }
        
        go(depth + 1, sum + numbers[depth], n, numbers, target);
        go(depth + 1, sum - numbers[depth], n, numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        go(0, 0, numbers.length, numbers, target);
        return cnt;
    }
}