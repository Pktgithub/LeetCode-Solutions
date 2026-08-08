class Solution {
    public int[] findErrorNums(int[] nums) {

        int[] ans = new int[2];

    
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                ans[0] = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }

        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[1] = i + 1; 
                break;
            }
        }

        return ans;
    }
}