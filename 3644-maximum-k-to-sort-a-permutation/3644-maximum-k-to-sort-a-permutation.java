class Solution {
    public int sortPermutation(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                ans.add(nums[i]);
            }
        }
        
        if(ans.size()==0) {
            return 0;
        }

        int result = -1; 
        for (int num : ans) {
            result &= num; // Same as: result = result & num;
        }
        return result;
    }
}