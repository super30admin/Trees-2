// 106. Construct Binary Tree from Inorder and Postorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/


/**
 * Time Complexity: o(n) since we process each node
 * Space Complexity: o(n) for map + o(h) where h is the height of tree = O(n)
 */

class Solution {

    Map<Integer, Integer> map;
    int rootIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.rootIdx = postorder.length - 1;
        this.map = new HashMap<>();

        if(inorder.length != postorder.length){
            return null;
        }

        if(inorder.length == 0){
            return null;
        }

        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int inorder[], int postorder[], int start, int end){
        // base condition
        if(start > end){
            return null;
        }


        // logic

        int rootValue = postorder[rootIdx];

        TreeNode root = new TreeNode(rootValue);

        int idx = map.get(rootValue); 

        rootIdx--;

        root.right = helper(inorder, postorder, idx + 1, end);
        root.left = helper(inorder, postorder, start, idx - 1);

        return root;
    }
}