// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// *****Construct Binary Tree from Inorder and Postorder Traversal*****//

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

//Approach 1
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0)
            return null;
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
        int index = -1;
        for(int i=0; i<inorder.length; i++){
                if(inorder[i] == node.val){
                index = i;
                break;
                }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0,index);
        int[] leftPos = Arrays.copyOfRange(postorder, 0,index);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] rightPos = Arrays.copyOfRange(postorder, index,postorder.length-1);
            
        node.left = buildTree(leftIn, leftPos);
        node.right = buildTree(rightIn, rightPos);
        return node;
        
    }
}

//TC - O(n squared)
//SC : O(h)


//Approach 2
class Solution {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        index = postorder.length-1;
        return build(inorder, postorder, map, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[index--]);
        int pos = map.get(root.val);
        root.right = build(inorder, postorder, map, pos+1, end);
        root.left = build(inorder, postorder, map, start, pos-1);
        return root;
    }
}

//TC : O(N)
//SC : O(N)




//*****Sum to Leaves 1 *****//

class Solution {int result = 0;
public int sumNumbers(TreeNode root) {
    helper(root, 0);
    return result;
}
private void helper(TreeNode root, int sum){
    if(root == null)
        return;
    
    if(root.left == null && root.right == null){
        sum = sum*10 + root.val;
        result+=sum;
        return;
    }
    
    helper(root.left,sum*10 + root.val);
    helper(root.right,sum*10 + root.val);
}
}
//TC : O(N)
//SC : O(h)