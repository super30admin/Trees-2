
//Construct Binary Tree
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach:Here we will get the root from the postorder array. We will
//find that root in the inorder .The left of the root says the left subtree and the right says right subtree(the left subtree is from start
// to rootindex-1 and right is from root+1 to end). we find the
//next root the postorder and follow the same approach till no roots are left in postorder.
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
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        if(inorder.length==0) return null;
        idx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1);
    }
    private TreeNode helper(int[] postorder,int start,int end){
        if(start>end) return null;
        int rootVal=postorder[idx];
        idx--;
        int rootIdx=map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right=helper(postorder,rootIdx+1,end);
        root.left = helper(postorder,start,rootIdx-1);
        return root;
    }
}


// sum root to leaf numbers
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach: Here we need to sum of the numbers from root to leaf
//numbers.Here in the recursive stack we will maintain the current number.According to the given requirement we need to
//multiply curr num with ten for each and every level.We will take currNUm as currnum*10+root.val. we check if it is the
//root node then we will add it to the sum global variable .

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
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root, int currNum){
        if(root==null) return;

        helper(root.left,currNum*10+root.val);
        if(root.left==null && root.right==null){
            sum+= currNum*10+root.val;
        }
        helper(root.right,currNum*10+root.val);

    }
}