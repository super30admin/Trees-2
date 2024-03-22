// Time Complexity : O(n) where 'n' is the number of nodes.
// Space Complexity : O(n) where 'n' is the number of nodes.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach:
store indixed of inorder traversal in a map
start iterating postorder from the end, for the val in post order, the index at which that value occurs is the root
we do recursive calls to call the helper function on right and then left half of that inorder array (choosing a value from preorder everytime)
*/
class Tree_InOrder_PostOrder{
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        idx = postorder.length-1;
        for(int i = 0; i < inorder.length ; i++){
                map.put(inorder[i],i);
        }
        return helper(map,0,inorder.length - 1, postorder );
    }
    private TreeNode helper(HashMap<Integer, Integer> map, int start, int end, int[] postorder){
        //base
        if(start > end || idx < 0) return null;
        int rootVal = postorder[idx];
        int rootIdx = map.get(rootVal);
        idx--;
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(map, rootIdx+1, end, postorder);
        root.left = helper(map, start, rootIdx - 1, postorder);
        return root;
    }
}