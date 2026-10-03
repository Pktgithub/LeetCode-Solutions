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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        markedParents(root, null, parentMap);

        TreeNode startNode = findNode(root, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);

        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean newInfectedNode = false;

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    q.offer(current.left);
                    visited.add(current.left);
                    newInfectedNode = true;
                }

                if (current.right != null && !visited.contains(current.right)) {
                    q.offer(current.right);
                    visited.add(current.right);
                    newInfectedNode = true;
                }

                TreeNode parent = parentMap.get(current);

                if(parent != null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                    newInfectedNode = true;
                }
            }
            if(newInfectedNode == true) {
                time++;
            }
            
        }
        return time;
    }

    private void markedParents(TreeNode node , TreeNode parents, HashMap<TreeNode, TreeNode>parentMap) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parents);

        markedParents(node.left, node, parentMap);
        markedParents(node.right, node, parentMap);
    }

    private TreeNode findNode(TreeNode node, int start){
        if(node == null) {
            return null;
        }
        if (node.val == start) {
            return node;
        }

        TreeNode left = findNode(node.left, start);

        if (left != null) {
            return left;
        }

        return findNode(node.right, start);
    }
}