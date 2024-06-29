// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// logic: It maps each value in the inorder array to its index for quick lookup and initializes an index for the postorder array's last element.
//Using a recursive function, it builds the tree by selecting the current root from the postorder array and splitting the inorder array into left and right subtrees.
//The recursion continues to construct the left and right subtrees until the entire tree is built.

class Solution {
    HashMap<Integer, Integer> map;
    int idx ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return null;
        }
        idx = postorder.length-1;
        map = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recurse(postorder, 0, inorder.length-1);
    }

    private TreeNode recurse(int[] postorder, int start, int end){

        // base
        if(start > end){
            return null;
        }

        // logic
        int rootval = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootval);
        int rootidx = map.get(rootval);

        root.right = recurse(postorder, rootidx + 1, end);
        root.left = recurse(postorder, start, rootidx - 1);

        return root;
    }
}