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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();

        if (root == null) {
            return ansList;
        }
        
        boolean leftRight = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
           

            for (int i =0; i < size; i++) {
                 TreeNode node = q.poll();
            level.add(node.val);
                if(node.left != null ) {
                    q.offer(node.left);
                }

                if(node.right != null ) {
                    q.offer(node.right);
                }
            }
            if ( leftRight != true ) {
                Collections.reverse(level);
                ansList.add(level);
                leftRight = true;
            } else {
                ansList.add(level);
                leftRight = false;
            }
        }

        return ansList;
    }
}