// Time Complexity : O(n), since each node is created from bottom up, most right child first then left child then upto root
// Space Complexity : O(n) hashmap, + O (log n) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : building the intuition of how the tree is built

// Your code here along with comments explaining your approach
// inorder is left-root-right
//postorder is left-right-root
//hence we know main root is postorder[postorder.length-1]
//we use inorder to calculate its left and right subtrees
//If look at postorder traversal in reverse, its root followed by its right children till no right child exists
//we build the main tree in a bottom up manner, rightmost child linked to root, then left child linked to root and build up
//kind of tricky to explain ... 

class Solution {
    int[] inorder;
    int[] postorder;
    int post_idx;
    HashMap<Integer, Integer> inorder_idx_map = new HashMap<Integer, Integer>();
        
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.post_idx = postorder.length-1;
        
        for(int i=0; i<inorder.length; i++){
            inorder_idx_map.put(inorder[i], i); 
        }
        
        return helper(0, inorder.length-1);
    }
    
    private TreeNode helper(int low, int high){
        
        if(low>high){
            return null;
        }
        
        int rootVal = postorder[post_idx];
        TreeNode root = new TreeNode(rootVal);
        post_idx--;
        
        int idx = inorder_idx_map.get(rootVal);
        
        root.right = helper(idx+1, high);
        root.left = helper(low, idx-1);
        return root;
    }
}