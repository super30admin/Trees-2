// Time Complexity : O(n) traverses through inorder array and another O(n) for recursive calls
// Space Complexity : O(n + h) space of recursive stack which stores node for all recursive calls and n is the total number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return null;
        }

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        index = postorder.length - 1;
        return postOrder(postorder, 0, inorder.length - 1);
    }

    private TreeNode postOrder(int[] postorder, int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = postorder[index];
        index--;

        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);

        root.right = postOrder(postorder, rootIndex + 1, end);
        root.left = postOrder(postorder, start, rootIndex - 1);

        return root;
    }
}
