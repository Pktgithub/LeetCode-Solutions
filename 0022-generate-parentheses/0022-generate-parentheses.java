class Solution {
    static void solve(int n , int open, int close, String current , List<String> result) {
        if (open == n && close == n) {
            result.add(current);
            return;
        }

        if (open < n) {
            solve(n,open+1,close, current+"(",result);
        }

        if ( close < open ) {
            solve(n,open,close+1, current+")",result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n,0,0,"",result);
        return result;
        
    }
}