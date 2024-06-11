//time O(n)
//space O(n)

class Solution {    
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length -1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end) {
        //base
        if(start > end) return null;
        
        //logic
        int rootVal = postorder[idx];
        idx--;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        return root;
    }
    
}
