class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack <>();

        for (int i = 0; i < num.length(); i++) {

            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        while( k > 0 ) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder(); 

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        String result = ans.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}    