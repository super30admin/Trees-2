// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

//Create left and right sub tree sub arrays and then pass it accordingly to the left and right recursive call
// for preorder the root is the first node in the array. 
// for inorder the root element is seached by linear search and then the index is obtained for dividing the array into tow

// Your code here along with comments explaining your approach
import java.util.Arrays;

public class ConstructFromPreAndInorder {
        public static TreeNode buildTree(int[] inorder, int[] postorder) {
            
            if(postorder.length == 0 || inorder.length == 0) return null;
            TreeNode root = new TreeNode();
            int rootVal = postorder[postorder.length-1];
            int idx = 0;
            for(int i = 0; i < inorder.length; i++) {
                if(inorder[i] == rootVal)
                    idx = i;
            }
            root.val = rootVal;
            
            int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
            int[] preLeft = Arrays.copyOfRange(postorder,0, idx);
            int[] inRight = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
            int[] preRight = Arrays.copyOfRange(postorder, preLeft.length, postorder.length-1);
            
            root.left = buildTree(inLeft, preLeft);
            root.right = buildTree(inRight, preRight);
            return root;
            
            
            
        }
    public static void main(String args[]) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {9,15,7,20,3};
       System.out.println(buildTree(inorder,preorder).val);
    }    

}


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

