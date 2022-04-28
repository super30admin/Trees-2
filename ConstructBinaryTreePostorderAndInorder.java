//time - O(n)
//space - O(n)
class Solution {
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || inorder==null || postorder.length==0 || inorder.length==0 || inorder.length!=postorder.length) return null;
        map = new HashMap<>();
        idx = postorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if(idx<0 || start > end) return null;

        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right = helper(inorder,postorder, rootIdx+1, end);
        root.left = helper(inorder,postorder, start, rootIdx-1);

        return root;
    }
}