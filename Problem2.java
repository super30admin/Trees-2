package Trees2;
/**
 * 
 * We do inorder traversal and at every node we update the recursion variable currVal(ie the concatenating of node vals upto that point) and as we reach a leaf node 
 * the currVal at that point is added to sum. Once a leaf node is processed then the recursion goes back to parent and uses the parent's currVal to process further.
 * 
 * Time Complexity :
 * O(n) - where n is the no of nodes.
 * 
 * Space Complexity :
 * O(n), actually is the height of the tree in worst case(skewed tree)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root.left==null && root.right==null)
            return root.val;
        helper(root, 0);
        return sum;
    }

    void helper(TreeNode node, int currVal){
        //base
        if(node==null)
            return;
        else if(node.left==null && node.right==null){
            currVal=currVal*10+node.val;
            sum=sum+currVal;
            return;
        }

        //logic
        currVal=currVal*10+node.val;
        helper(node.left, currVal);
        helper(node.right,currVal);

    }

}
