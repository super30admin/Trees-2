/**
// Time Complexity : O(n)
// Space Complexity : O(n) for hashmap, containting all node and node indexes.
                      O(n) stack memory for all node recursion.

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  //problem simillar to inorder and preorder problem.

// Your code here along with comments explaining your approach
 */
class Solution {
    //create inorder node and indx map.
    HashMap<Integer, Integer> hmp = new HashMap<>();
    //create postIndx for indx in postorder array , strting from
    //postorder.length -1.
    int postIndx;

    private TreeNode helper(int[] inorder, int[] postorder, int strt, int end){
        if(strt > end)
            return null;

        //create next node in postorder array.
        //since this is root node for subtree.
        int val = postorder[postIndx--];
        int valIndx = hmp.get(val);
        TreeNode node = new TreeNode(val);

        node.right = helper(inorder, postorder, valIndx+1, end);
        node.left = helper(inorder, postorder, strt, valIndx-1);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndx = postorder.length-1;
        for(int i = 0 ; i < inorder.length; i++){
            hmp.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length-1);
    }
}
