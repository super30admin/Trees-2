// Time complexity : O(N)
// Space complexity: O(N)

class Solution {
    HashMap<Integer,Integer> map;
    int postorderIdx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length-1;
        // build a hashmap to store value -> its index relations
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end) {
        // base
        // if there are no elements to construct the tree. If start has exceeded end
        if (start > end) return null;
        
        // logic
        // select the postorder_index element as the root and increment the preorder index
        TreeNode root = new TreeNode(postorder[postorderIdx]);
        postorderIdx--;
        int rootIdx = map.get(root.val); // get roots index in inorder map
        root.right = helper(postorder, rootIdx+1, end); // build right subtree
        root.left = helper(postorder, start, rootIdx-1); // build left subtree
        return root;
    }
}