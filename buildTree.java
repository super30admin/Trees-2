// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    HashMap<Integer,Integer> map;
    int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.map = new HashMap<>();
        postOrderIdx = postorder.length-1;

        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){

        if(start > end) return null;

        int rootVal = postorder[postOrderIdx];
        int rootIdx = map.get(rootVal);
        postOrderIdx--;

        TreeNode node = new TreeNode(rootVal);

        node.right = helper(postorder,rootIdx+1,end);
        node.left = helper(postorder,start,rootIdx-1);

        return node;
    }
}
