class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int i = 0;

        for (int num = 1; num <= n && i < target.length; num++) {
            if ( num == target[i]) {
                ans.add("Push");
                i++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }

        return ans;
    }
}