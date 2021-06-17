/** SC O(N^2) TC (ON^2) 
 * Ran on leetcode - yes
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null; 
        if (postorder.length == 0){return null;}
        int start = postorder[postorder.length-1];
           
        int idx = 0;
        for (int i = 0 ; i < inorder.length; i++){
            if (inorder[i] == start){
                  idx = i;
                  break;
            }
        }

        root = new TreeNode(inorder[idx]);
	// inorder left part
        int[] newInorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] newInorder2 = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] subleftpost  = Arrays.copyOfRange(postorder,0,idx);
        int[] subrightpost = Arrays.copyOfRange(postorder,idx,postorder.length-1);
        root.left = buildTree( newInorder, subleftpost);
        root.right = buildTree(newInorder2,subrightpost);
     
        return root;
        
    }
}
