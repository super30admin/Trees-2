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

//TimeComplexity:O(N)
//SpaceComplexity:O(H)
class Pair{
    TreeNode root;
    int sum;

    Pair(TreeNode root, int sum){
        this.root=root;
        this.sum= sum;
    }

    public TreeNode getKey(){
        return this.root;
    }
    public int getSum(){
        return this.sum;
    }
}
class Solution {
    int resultSum;
    public int sumNumbers(TreeNode root) {
        int currentSum=0;

        if(root == null){
            return 0;
        }

        Stack<Pair> st = new Stack<>();
        while(root!=null || !st.isEmpty() ){
            while(root!=null){
                currentSum= (currentSum*10) + root.val;
                st.push(new Pair(root,currentSum));
                root=root.left;
            }

            Pair p = st.pop();
            root = p.getKey();
            currentSum = p.getSum();

            if(root.left == null && root.right == null){
                resultSum += currentSum;
            }
            root = root.right;
        }
        return resultSum;
    }
}