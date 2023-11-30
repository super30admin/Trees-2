// Time Complexity: O(n)
// Space Compexity: O(n) 
class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int poststart = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i = 0; i< inorder.length; i++) map.put(inorder[i], i);
        poststart = postorder.length - 1;
        return createTree(inorder, postorder, 0, postorder.length-1);

    }

    public TreeNode createTree(int[] inorder, int[] postorder, int instart, int inend){
        if(instart > inend) return null;
        TreeNode node = new TreeNode(postorder[poststart--]);
        if(instart == inend)
            return node;
        int inindex = map.get(node.val);
        node.right = createTree(inorder, postorder, inindex + 1, inend);
        node.left = createTree(inorder, postorder, instart, inindex - 1);
        return node;

    }
}