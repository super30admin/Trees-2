// Time Complexity : O(n)
// Space Complexity :O(height * 2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
//we use 3 pointers here, one for postorder which will tell us about the root and to for inorder which tell 
//us about start and end indexes. in postorder, the root elements are in the end so we start from end
//when we start we initialize postIndex and decrement it in each call. value at postIndex is the root
//so we find this root in inorder (we first store inorder in a hashMap so that we dont need to use for loop)
//each time. now all the values in postorder should be stored as keys and indexes as values as we will be
//searching for those root values and store the value as "index". right subtree consists of everything 
//on the right of this index till inEnd (endpoint of inorder) and left tree consists of everything
//starting from 0th index (inStart) till index (excluding it). this way we know how to form further
//trees. so using these values we construst the tree. when start is greter than end we return null
//that happens at leaf nodes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private HashMap<Integer, Integer> hashMap;
    private int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder ) {
        if(postorder==null || inorder==null)
            return null;
        
        
        hashMap=new HashMap<>();
        postIndex=(postorder.length) - 1;
        
        for(int i=0; i<inorder.length; i++){
            hashMap.put(inorder[i], i);
        }  
        
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1);
        
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end){
        if(start>end)
            return null;
        
        TreeNode root= new TreeNode(postorder[postIndex]);
        postIndex--;
        
        int index=hashMap.get(root.val);
        
        root.right= buildTreeHelper(inorder, postorder, index + 1, end);
        root.left= buildTreeHelper(inorder, postorder, start, index-1);
        
        return root;
    }
}