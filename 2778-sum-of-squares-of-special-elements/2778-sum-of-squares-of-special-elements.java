class Solution {
    public int sumOfSquares(int[] nums) {
        
        int sum = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++ ) {
            int indx = i+1;
            if ( n % indx == 0) {
                sum += nums[i]*nums[i];
            }
        }

        return sum;
    }
}