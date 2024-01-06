// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {
    
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = postorder.length;
        postIndex = n - 1;

        for(int i = 0; i < n; i++) map.put(inorder[i], i);

        return helper(0, n - 1, postorder);
    }

    private TreeNode helper(int left, int right, int[] post)
    {
        if(left > right) return null;

        TreeNode root = new TreeNode(post[postIndex--]);

        // We do right recursion first because postorder is Left Right Root and we are traversing postorder array from 
        // backwards so that means when we consider root after that we need to set the right recursion and then left 
        // recursion which is like reverse of postorder.

        // For better understanding also look into the given input graph and post order array all the root nodes were filling
        // up from right to left.

        int index = map.get(root.val);

        root.right = helper(index + 1, right, post);

        root.left = helper(left, index - 1, post);

        return root;
    }
}