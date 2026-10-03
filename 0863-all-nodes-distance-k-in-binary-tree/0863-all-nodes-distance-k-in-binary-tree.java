/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

        markParents(root, null, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            if(distance == k ) {
                List<Integer> ansList = new ArrayList<>();
                while(!q.isEmpty()) {
                    ansList.add(q.poll().val);
                }
                return ansList;
            }

            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    q.offer(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    q.offer(current.right);
                    visited.add(current.right);
                }

                 TreeNode parent = parentMap.get(current);

                if (parent != null &&
                    !visited.contains(parent)) {

                    q.offer(parent);
                    visited.add(parent);
                }
                
            }
            distance++;
        }
        return new ArrayList<>();
    }

    private void markParents(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }

        parentMap.put(node, parent);

        markParents(node.left, node, parentMap);
        markParents(node.right, node, parentMap);
    }
}