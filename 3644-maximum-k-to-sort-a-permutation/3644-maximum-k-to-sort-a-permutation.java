class Solution {
    public int sortPermutation(int[] nums) {
        // ArrayList<Integer> ans = new ArrayList<>();
        
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                result &= nums[i];
            }
        }

        return result == -1 ? 0 : result;

        // if(ans.size()==0) {
        //     return 0;
        // }

        // int result = -1; 
        // for (int num : ans) {
        //     result &= num; // Same as: result = result & num;
        // }
        // return result;
    }
}