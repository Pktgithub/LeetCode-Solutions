class Solution {
    static void solve (int[] nums, int index, List<List<Integer>> ans, List<Integer> output ) {
        if (index >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        output.add(nums[index]);
        solve(nums, index+1, ans, output);
        output.remove(output.size()-1);

        while(index+1 < nums.length && nums[index]==nums[index+1]) {
            index++;
        }
        solve(nums, index+1, ans, output);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int index = 0;

        solve(nums,index,ans,output);
        return ans;
    }
}