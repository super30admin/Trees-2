import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N

public class ConstructTree {
    
     HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = postorder.length-1;
        for(int i=0; i< inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length -1);
    }
    private TreeNode helper(int[] postorder, int start, int end)
    {
        if(start>end || idx < 0)
        {
            return null;
        }
        
    
        int rootVal = postorder[idx];
        int rootidx = map.get(rootVal);
        idx--;
        TreeNode root = new TreeNode(rootVal);
        
        root.right = helper(postorder, rootidx + 1, end);
        root.left = helper(postorder, start, rootidx -1);
        return root;

    }
    public static void main(String[] args) {
        ConstructTree constructTree = new ConstructTree();

        // Example input arrays for preorder and inorder traversals
        int[] postorder = { 9,15,7,20,3};
        int[] inorder = { 9,3,15,20,7};

        // Call the buildTree method to construct the binary tree
        TreeNode root = constructTree.buildTree(inorder, postorder);

        // call a print method on the tree
        printTree(root);
    }

    // Example print method for the tree
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        // Perform any desired operation with the current node value
        System.out.print(root.val + " ");

        // Recursively print left and right subtrees
        printTree(root.left);
        printTree(root.right);
    }
}
