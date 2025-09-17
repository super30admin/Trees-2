// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We get the pointer to each node by indexing on the postorder list and using Hash map we search for the root in inorder list
//we recursively calculate the right and left subtree of root using start and end indices on inorder list
//Recursion stops or returns null when start and end index cross each other
class Solution {
    int idx; //index on postorder
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = postorder.length - 1;
        for(int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        //base
        if (start > end) return null;
        //logic
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        //get the root value index in inorder list
        int rootIdx = map.get(rootVal);
        //right
        root.right = helper(postorder, rootIdx+1, end);
        //left
        root.left = helper(postorder, start, rootIdx - 1);
    
        return root;

    }
}
