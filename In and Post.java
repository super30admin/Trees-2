// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int postOrderIndex;
    int[] postorder;
    int[] inorder;
    HashMap<Integer,Integer> inorderIndexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.postOrderIndex = postorder.length-1;
        this.inorderIndexMap = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return helper(0,this.postOrderIndex);
    }
    
    private TreeNode helper(int start,int end){
        if(start > end) return null;
        int rootValue = this.postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);
        int split = this.inorderIndexMap.get(rootValue);
        root.right = helper(split+1,end);
        root.left = helper(start,split-1);
        return root;
    }
}
