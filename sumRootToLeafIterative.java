//time complexity O(n)
//space complexity O(h) where h is the height of the tree

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
    class Pair {
        TreeNode node;
        int localSum;
        public Pair(TreeNode node, int localSum){
            this.node = node;
            this.localSum = localSum;
        }
        public TreeNode getNode(){
            return this.node;
        }
        public int getLocalSum(){
            return this.localSum;
        }
    }
    public int sumNumbers(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        if(root == null) return 0;
        int sum = 0; int result = 0;
        while(root != null || !st.isEmpty()){
            while(root != null){
                sum = sum * 10 + root.val;
                st.push(new Pair(root, sum));
                root = root.left;
            }
            Pair p = st.pop();
            sum = p.getLocalSum();
            root = p.getNode();
            if(root.left == null && root.right == null){
                result += sum;
            }
            root = root.right;
        }
        return result;
    }
}
