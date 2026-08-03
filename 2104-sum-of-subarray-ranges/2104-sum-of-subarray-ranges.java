import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        int[] pge = new int[n]; // Previous Greater Element
        int[] nge = new int[n]; // Next Greater Element
        int[] pse = new int[n]; // Previous Smaller Element
        int[] nse = new int[n]; // Next Smaller Element

        Stack<Integer> st = new Stack<>();

        // Previous Greater Element (strictly greater)
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }


        st.clear();


        // Next Greater Element (greater or equal)
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }


        st.clear();


        // Previous Smaller Element (smaller or equal)
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }


        st.clear();


        // Next Smaller Element (strictly smaller)
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }


        long maxSum = 0;
        long minSum = 0;


       
        for (int i = 0; i < n; i++) {

            long leftMax = i - pge[i];
            long rightMax = nge[i] - i;

            maxSum += (long) nums[i] * leftMax * rightMax;


            long leftMin = i - pse[i];
            long rightMin = nse[i] - i;

            minSum += (long) nums[i] * leftMin * rightMin;
        }


        return maxSum - minSum;
    }
}