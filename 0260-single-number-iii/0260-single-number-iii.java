class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int [2];

        int xor = 0;

        for (int num : nums ) {
            xor^= num;
        }

        int setBit = xor & (-xor);

        int num1 = 0;
        int num2 = 0;

        for (int num : nums ) {
            if ((num & setBit) == 0) {
                num1 ^= num;
                ans[0] = num1;
            }else {
                num2 ^= num;
                ans[1] = num2;
            }
        }

        return ans;
    }
}