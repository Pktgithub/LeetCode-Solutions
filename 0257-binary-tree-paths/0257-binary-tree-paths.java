/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void solve (TreeNode root, String path, List<String> ans ) {

        if (root.left == null && root.right == null ) {
            path += root.val;
            ans.add(path);
            return;
        }

        path += root.val + "->";

        if(root.left != null ) {
            solve(root.left, path, ans);
        }

        if(root.right != null ) {
            solve(root.right, path, ans);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ans = new ArrayList<>();
       if( root == null ) {
        return ans;
       }

       solve (root, "", ans);
       return ans;

    }

    
}