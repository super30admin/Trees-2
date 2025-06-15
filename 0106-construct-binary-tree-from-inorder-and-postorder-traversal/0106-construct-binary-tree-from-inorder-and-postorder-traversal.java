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

    //Declare an integer to keep track of the current index in the postorder array
    int post_idx;

    //Declare an array to store a post order traversal
    int[] postorder;

    //Declare an array to store an inorder traversal
    int[] inorder;

    //Create a HashMap to store the index of each value in the inorder array for a quick lookup
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    //Define a recursive helper method that will construct the tree
    public TreeNode helper(int in_left, int in_right){
        //Base case: if there are no elements to construct subtree, return null
        if(in_left> in_right) return null;

        //Select the lement at post_idx from the postorder array as the root value
        int root_val = postorder[post_idx];

        //Create a new tree node with the root value
        TreeNode root = new TreeNode(root_val);

        //Find the index of the rootvalue in the inorder array using the HashMap
        int index = idx_map.get(root_val);

        //Decrement post_idx to move to the next element in the postorder array
        post_idx--;

        //Recursively build the right subtree first, using elements to the right of the root in the inorder array
        root.right = helper(index+1, in_right);

        //Recursively build the left subtree, using elements to the left of the root in the inorder array
        root.left = helper(in_left, index-1);

        //Return the constructed subtree rooted at root
        return root;

    }


    

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Assign the postorder array to the class variable
        this.postorder = postorder;

        //Assign the inorder array to the class variable
        this.inorder = inorder;

        //Initialize post_idx to the last index of the post order array
        post_idx = postorder.length-1;

        //Populate the hashmap with values from inorder array and their corresponding indices
        int idx=0;
        for(Integer val: inorder){
            idx_map.put(val,idx++);

        }

        //Start building the tree from the entire range of the inorder array
        return helper(0, inorder.length-1);

        
    }
}