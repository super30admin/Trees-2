//The approach here is to use pointers start and end to get the left and right subtrees of a node in postorder array from the root index in inorder array.
//We get root value as the last element of the post order array and we traverse till the start of the array
//We also get the start and end pointers indices from inorder array and we get the root index for the root value from inorder array using hashmap.
//Time complexity: O(n)
//Space complexity: O(n)
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        idx = postorder.length-1;
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
        //basecase
        if(start>end) return null;
        //logic
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder, start, rootIdx-1);

        return root;

    }
}
