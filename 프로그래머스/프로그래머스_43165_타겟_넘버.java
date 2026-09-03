class Solution {
	static int go(int size, int sum, int[] numbers, int target){
		if(size > numbers.length - 1){
			return (sum == target) ? 1 : 0;
		}
		
		return go(size + 1, sum + numbers[size], numbers, target) 
		+ go(size + 1, sum - numbers[size], numbers, target); 
	}

    public int solution(int[] numbers, int target) {
        return go(0, 0, numbers, target);
    }
}