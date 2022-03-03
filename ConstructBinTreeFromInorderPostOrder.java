// Time Complexity : O(n) using hashmap else O(n^2) without HashMap; for every node we are checking in order position and then doing.
// Space Complexity : O(1) if recursion ignore but if so then ~ Implicit stack O(H); if tree is skewed
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/652832914/)
// Any problem you faced while coding this : No
// My Notes : Approach 1 : visit the nodes in the postorder from reverse and split the inorders
class Solution {
    // Created hashmap to store the inorder index position to retreive in constant time
    HashMap<Integer, Integer> map = new HashMap<>();
    // Decrement postIdx of node after creating the node
    int postIdx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;
        // Create hashmap tp get the index position of the inorder element.
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        //System.out.println(" Map : "+map);
        return buildTree(postorder, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] postorder, int left, int right){
         // if right child is (left,right) is 4,4 then left, right node will be 5,4 & 4,3 where it will break and the children would be null with only node created.
        if(left>right){
            return null;
        }
        // Create node from the postorder and then decrement
        TreeNode root = new TreeNode(postorder[postIdx--]);
        int inorderIdx = map.get(root.val);
        //System.out.println(" Created node "+root.val +" left,right"+left+","+right);
        // right subtree range from idx+1 till the end
        root.right = buildTree(postorder, inorderIdx + 1, right);
        // left node range from start till the idx-1
        root.left = buildTree(postorder, left, inorderIdx - 1);
        return root;
    }
}