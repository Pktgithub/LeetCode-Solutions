
class Solution {

    private int checkIncreasing(int[] num) {
        int maxInc = 1;
        int loopMax = 1;

        for (int i = 0; i < num.length - 1; i++) {

            if (num[i] < num[i + 1]) {
                loopMax++;
            } else {
                maxInc = Math.max(maxInc, loopMax);
                loopMax = 1;
            }
        }

        maxInc = Math.max(maxInc, loopMax);

        return maxInc;
    }

    private int checkDecreasing(int[] num) {
        int maxDec = 1;
        int loopMax = 1;

        for (int i = 0; i < num.length - 1; i++) {

            if (num[i] > num[i + 1]) {
                loopMax++;
            } else {
                maxDec = Math.max(maxDec, loopMax);
                loopMax = 1;
            }
        }

        maxDec = Math.max(maxDec, loopMax);

        return maxDec;
    }

    public int longestMonotonicSubarray(int[] nums) {

        int first = checkIncreasing(nums);
        int second = checkDecreasing(nums);

        return Math.max(first, second);
    }
}
