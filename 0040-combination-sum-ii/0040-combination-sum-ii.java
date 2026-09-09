class Solution {

    static void solve (int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> result ) {

        if (target == 0) {
            ans.add(new ArrayList(result));
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        if (target < 0) {
            return;
        }

        result.add(candidates[index]);
        solve(candidates, target-candidates[index], index+1, ans, result);
        //back track karna padega
        result.remove(result.size()-1);
        //duplicates exclude karne ke lia

        while (index+1 < candidates.length && candidates[index] == candidates[index+1]) {
            index++;
        }
        solve(candidates, target, index+1, ans, result);

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int index = 0;

        solve(candidates, target, index, ans, result);
        return ans;
    }
}