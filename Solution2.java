// Time Complexity: O(n)
// Space Complexity: O(H)

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
class Solution2 {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> mst = new Stack<>();
        int curr = 0;
        int result = 0;
        while(root != null || !st.isEmpty() ) {
            while( root != null ) {
                curr = curr*10 + root.val;
                st.push(root);
                mst.push(curr);
                root = root.left;
            }
            root = st.pop();
            curr = mst.pop();
            if( root.left == null && root.right == null) {
                result = result + curr;
            }
            root = root.right;
        }
        return result;
    }
}
// class Solution {
//     int sum;
//     public int sumNumbers(TreeNode root) {
//         helper(root, 0);
//         return sum;
//     }

//     public void helper(TreeNode root, int currSum) {
//         //base case
//         currSum = currSum*10 + root.val;
//         // System.out.println(root.val);
//         // System.out.println(currSum);
//         // System.out.println("xxxx");
//         if( root.left == null && root.right == null ) {
//             sum = sum + currSum;
//             return;
//         }
//         if(root.left != null ) {
//             helper(root.left, currSum*10 + root.val);
//         }
//         if( root.right != null ) {
//             helper(root.right, currSum*10 + root.val);
//         }
//     }
// }