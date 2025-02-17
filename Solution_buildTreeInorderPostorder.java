//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_buildTreeInorderPostorder {
    int ind;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        ind = postorder.length-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, map, 0, inorder.length-1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int start, int end){
        if(start > end){
            return null;
        }
        int rootVal = postorder[ind];
        ind--;
        int rootInd = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(inorder, postorder, map, rootInd+1, end);
        root.left = helper(inorder, postorder, map, start, rootInd-1);
        return root;
    }
}
