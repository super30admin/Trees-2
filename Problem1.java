package Trees2;

import java.util.HashMap;

/**
 * 
 * We do know the the last element of postorder array is always the current root and we can deduce span of left and right subtree using inorder array.
 * We use pointers to vary the low and high of both arrays and recursively construct first the right subtree and then the left subtree using the corresponding inorder and preorder arrays.
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Problem1 {
    HashMap<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0;i<postorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
                
    }

        TreeNode helper(int[] postorder,int leftPost,int rightPost, int[] inorder, int leftIn, int rightIn){
            //base
            if(rightPost<leftPost || rightIn<leftIn)
                return null;

            int rootVal=postorder[rightPost];
            int rootIdx=map.get(rootVal);
            //no of elements to the right of rootIdx in inoder array 
            int rightDiff=rightIn-rootIdx;

            TreeNode node= new TreeNode(rootVal);

            node.right=helper(postorder, rightPost-rightDiff, rightPost-1,inorder,rootIdx+1,rightIn);

            node.left=helper(postorder, leftPost, rightPost-rightDiff-1, inorder, leftIn,rootIdx-1);

            return node;}

}
