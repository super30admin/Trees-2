/**Leetcode Question 129 - Sum Root to Leaf Number */
/**Algorithm - Inorder Traversal
 * Maintain a currsum which indicates the sum at the current root
 * Maintain a global result which contains the addition of all the root to leaf node paths
 */
/**TC- O(N)
 * SC- O(1)
 */
public class SumRootLeaf {
    class Solution {
        int sum;
        int result;
        public int sumNumbers(TreeNode root) {
            if(root == null){
                return 0;
            }
            return inorder(root, sum);
        }
        private int inorder(TreeNode root, int sum){
            if(root == null){
                return 0;
            }
            int currsum = sum * 10 + root.val;
            inorder(root.left, currsum);
            if(root.left == null && root.right == null){
                result += currsum;
            }
            inorder(root.right, currsum);
            return result;
        }
    } 
}
