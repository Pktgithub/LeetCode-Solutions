// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//         List<List<Integer>> ans = new ArrayList<>();

//         for (int val : queries) {
//             List<Integer> valList = new ArrayList<>();
//             int ceil = findCeil(root, val);
//             int floor = findFloor(root, val);

//             valList.add(floor);
//             valList.add(ceil);
            
//             ans.add(valList);
//         }

//         return ans;

//     }

//     private int findCeil(TreeNode root, int key) {
//         int ceil = -1;
//         while (root != null) {
//             if (root.val == key) {
//                 return root.val;
//             }

//             if (root.val > key) {
//                 ceil = root.val;
//                 root = root.left;
//             } else {
//                 root = root.right;
//             }
//         }

//         return ceil;
//     }

//     private int findFloor(TreeNode root, int key) {
//         int floor = -1;
//         while (root != null) {
//             if (root.val == key) {
//                 return root.val;
//             }

//             if (root.val > key) {

//                 root = root.left;
//             } else {
//                 floor = root.val;
//                 root = root.right;
//             }
//         }

//         return floor;
//     }
// }

class Solution {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int query : queries) {

            int index = lowerBound(nums, query);

            int floor = -1;
            int ceil = -1;

            // ceil
            if (index < nums.size()) {
                ceil = nums.get(index);
            }

            // floor
            if (index < nums.size() && nums.get(index) == query) {
                floor = query;
            } 
            else if (index > 0) {
                floor = nums.get(index - 1);
            }

            List<Integer> list = new ArrayList<>();
            list.add(floor);
            list.add(ceil);

            ans.add(list);
        }

        return ans;
    }

    private void inorder(TreeNode root, List<Integer> nums) {

        if (root == null) {
            return;
        }

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private int lowerBound(List<Integer> nums, int target) {

        int left = 0;
        int right = nums.size();

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums.get(mid) >= target) {
                right = mid;
            } 
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}