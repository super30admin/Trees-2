
//Time Complexity: O(n)
//Space complexity:O(1)
public class Solution2 {
	HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        index = postorder.length - 1;
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
    	if(start > end ) return null;
    	TreeNode root = new TreeNode(postorder[index]);
    	int rootIdx = map.get(postorder[index]);
        index = index - 1;
        root.right = helper(postorder , rootIdx + 1, end);
        root.left = helper(postorder , start, rootIdx - 1);
        return root;
    }
}
