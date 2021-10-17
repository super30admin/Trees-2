// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
        private HashMap<Integer, Integer> map;
        private int postIndex; // the node that we have target - postorder's last element is always the root
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder == null || inorder == null) 
            return null;
        map = new HashMap<>();
        //the last node in preorder is the root
        postIndex = postorder.length - 1;
        
        //we are using hashmap to find the index each time in the inorder traversal
        for(int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        //Root, Right, Left
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        int index = map.get(root.val);
        root.right = helper(inorder, postorder, index + 1, inEnd);
        root.left = helper(inorder, postorder, inStart, index - 1);
        return root;
    }
