//Sum Root to Leaf Numbers
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
used recursion approach. inrder traversal of the tree and keep on adding the node values. 
Once we reach the leaf node, we add the currSum to the totalSum. We return the totalSum
*/
public class Problem2 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));

    }
    public static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        inorderTraversal(root,0);
        return sum;
    }
    public static void inorderTraversal(TreeNode root, int currSum){
        if(root == null)
            return;
        currSum = currSum*10 + root.val;
        inorderTraversal(root.left, currSum);
        if(root.left == null && root.right == null){
            sum += currSum;
            
        }
        inorderTraversal(root.right, currSum);

    }
    
}
